package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryRepository;
import com.ajegames.storytime.model.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/storytime/story")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoryResource {

    private static Logger LOG = LoggerFactory.getLogger(StoryResource.class);

    private StoryRepository repo = StoryRepository.getInstance();

    @POST
    public Story create(Story story) {
        LOG.info("Creating another story for a happier universe.");
        Story result;
        try {
            result = repo.addStory(story);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        return result;
    }

    @GET
    @Path("{key}")
    public Story get(@PathParam("key") String key) {
        LOG.info("Retrieving story for key:" + key);
        return repo.getStory(key);
    }

    @PUT
    @Path("{key}")
    public void update(@PathParam("key") String key, Story storyUpdate) {
        LOG.info("Receiving changes to story: " + key);
        if (!key.equals(storyUpdate.getKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        repo.updateStory(storyUpdate);
    }

    @DELETE
    @Path("{key}")
    public void destroy(@PathParam("key") String key) {
        LOG.info("Eliminating entire story: " + key);
        repo.removeStory(key);
    }
}
