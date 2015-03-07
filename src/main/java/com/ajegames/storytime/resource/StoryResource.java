package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryTimeRepository;
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

    private StoryTimeRepository repo = StoryTimeRepository.getInstance();

    @POST
    public void create(Story story) {
        LOG.info("Creating another story for a happier universe.");
        try {
            repo.addStory(story);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }

    @GET
    @Path("{key}")
    public Story get(@PathParam("key") String key) {
        return repo.getStory(key);
    }
}
