package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.StoryController;
import com.ajegames.storytime.model.view.StandaloneChapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/story/{key}/chapter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChapterResource {

    private static Logger LOG = LoggerFactory.getLogger(ChapterResource.class);

    private StoryController ctrl = new StoryController();

    @GET
    @Path("{id}")
    public StandaloneChapter get(@PathParam("key") String key, @PathParam("id") Integer id) {
        LOG.info("Retrieving chapter " + id + " for story " + key);
        Chapter chapter = ctrl.getChapter(key, id);
        if (chapter == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return StandaloneChapter.createFromChapter(chapter);
    }

    @PUT
    @Path("{id}")
    public Chapter update(@PathParam("key") String key, Chapter update) {
        LOG.info("Receiving changes to story: " + key);
        if (key == null || update.getId() == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            return ctrl.updateChapter(key, update);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

//    @POST
//    public Chapter addNextChapter(@PathParam("key") String key, NextChapter nextChapter) {
//        LOG.info("Adding next chapter");
//        try {
//            return ctrl.addNextChapter(key, nextChapter.getParentID(), nextChapter.getTeaser());
//        } catch (Exception e) {
//            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
//        }
//    }

}
