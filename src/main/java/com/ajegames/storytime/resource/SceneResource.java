package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.SceneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/storytime/scene")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SceneResource {

    private static Logger LOG = LoggerFactory.getLogger(SceneResource.class);

    private StoryTimeRepository repo = StoryTimeRepository.getInstance();

    @POST
    public Scene create(String storyKey, Scene aScene) {
        LOG.info("Adding a scene to story");
        Scene result;
        try {
            result = repo.addScene(aScene);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        return result;
    }

    @POST
    @Path("summary")
    public SceneSummary createFromSummary(String storyKey, SceneSummary summary) {
        LOG.info("Adding a scene to story");
        SceneSummary result;
        try {
            result = repo.addScene(summary);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        return result;
    }

    @GET
    @Path("{key}")
    public Scene get(@PathParam("key") String key) {
        return repo.getScene(key);
    }

    @PUT
    @Path("{key}")
    public void update(@PathParam("key") String key, Scene sceneUpdate) {
        LOG.info("Receiving changes to scene.");
        if (!key.equals(sceneUpdate.getKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        repo.updateScene(sceneUpdate);
    }

    @DELETE
    @Path("{key}")
    public void destroy(@PathParam("key") String key) {
        repo.removeScene(key);
    }
}
