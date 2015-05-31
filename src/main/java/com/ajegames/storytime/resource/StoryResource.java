package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/story")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoryResource {

    private static Logger LOG = LoggerFactory.getLogger(StoryResource.class);

    private StoryController ctrl = new StoryController();

    @GET
    @Path("{key}")
    public Story get(@PathParam("key") String key) {
        LOG.info("Retrieving story for key:" + key);
        Story story = ctrl.getStory(key);
        if (story == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return story;
    }

    @POST
    public Story create(Story story) {
        LOG.info("Creating another story for a happier universe.");
        try {
            return ctrl.createStory(story.getTitle(), story.getAuthor(), story.getTagLine(), story.getDescription());
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Path("{key}")
    public Story update(@PathParam("key") String key, Story update) {
        LOG.info("Receiving changes to story: " + key);
        if (update.getKey() != null && !key.equals(update.getKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            return ctrl.updateStory(update);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("{key}")
    public void destroy(@PathParam("key") String key) {
        LOG.info("Eliminating entire story: " + key);
        try {
            ctrl.deleteStory(key);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
