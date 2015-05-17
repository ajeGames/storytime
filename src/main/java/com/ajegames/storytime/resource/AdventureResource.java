package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.Adventure;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/adventure")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdventureResource {

    private static Logger LOG = LoggerFactory.getLogger(AdventureResource.class);

    private StoryController ctrl = new StoryController();

    @GET
    @Path("{key}")
    public Adventure get(@PathParam("key") String key) {
        LOG.info("Retrieving story for key:" + key);
        try {
            return ctrl.getAdventure(key);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    public Adventure create(Adventure story) {
        LOG.info("Creating another story for a happier universe.");
        Adventure result;
        try {
            result = ctrl.createAdventure(story.getTitle(), story.getAuthor(), story.getTagLine(), story.getDescription());
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @PUT
    @Path("{key}")
    public void update(@PathParam("key") String key, Adventure update) {
        LOG.info("Receiving changes to story: " + key);
        if (!key.equals(update.getKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        try {
            ctrl.updateAdventure(update);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("{key}")
    public void destroy(@PathParam("key") String key) {
        LOG.info("Eliminating entire story: " + key);
        try {
            ctrl.deleteAdventure(key);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
