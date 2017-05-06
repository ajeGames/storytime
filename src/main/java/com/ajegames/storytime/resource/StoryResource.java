package com.ajegames.storytime.resource;

import com.ajegames.storytime.StoryTimeApplication;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import org.slf4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/story")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoryResource {

    private static Logger LOG = StoryTimeApplication.KEY_EVENT_LOG;

    private StoryController ctrl = StoryController.create();

    @GET
    @Path("{key}")
    public StorySummary getStorySummary(@PathParam("key") String key) {
        LOG.info("Retrieving story for key: " + key);
        Story story = ctrl.getStory(key);
        if (story == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return story.getSummary();
    }

    @GET
    @Path("{key}/full")
    public Story getFullStory(@PathParam("key") String key) {
        LOG.info("Retrieving story for key: " + key);
        Story story = ctrl.getStory(key);
        if (story == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return story;
    }

    @POST
    public StorySummary createStory(StorySummary summary) {
        LOG.info("Creating another story for a happier universe.");
        try {
            return ctrl.createStory(summary);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Path("{key}")
    public StorySummary updateStory(@PathParam("key") String key, StorySummary update) {
        LOG.info("Receiving changes to story: " + key);
        if (update.getStoryKey() != null && !key.equals(update.getStoryKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            ctrl.updateSummary(update);
            return ctrl.getStory(update.getStoryKey()).getSummary();
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("{key}")
    public void destroyStory(@PathParam("key") String key) {
        LOG.info("Eliminating entire story: " + key);
        try {
            ctrl.deleteStory(key);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
