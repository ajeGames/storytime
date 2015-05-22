package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.StoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/adventure/{key}/chapter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChapterResource {

    private static Logger LOG = LoggerFactory.getLogger(ChapterResource.class);

    private StoryController ctrl = new StoryController();

    @GET
    @Path("{id}")
    public Chapter get(@PathParam("key") String key, @PathParam("id") Integer id) {
        LOG.info("Retrieving chapter " + id + " for story " + key);
        try {
            return ctrl.getChapter(key, id);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
