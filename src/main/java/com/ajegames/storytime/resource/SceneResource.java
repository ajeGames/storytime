package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryPersistence;
import com.ajegames.storytime.data.StoryRepository;
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

    @POST
    public Scene create(String storyKey, Scene aScene) {
        LOG.info("Adding a scene to story");
        Scene result;
        try {
            result = StoryPersistence.getStoryRepository().addScene(aScene);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        return result;
    }

    @POST
    @Path("summary")
    public Scene createFromSummary(String storyKey, SceneSummary summary) {
        LOG.info("Adding a scene to story");
        Scene result;
        try {
            Scene sceneToAdd = Scene.createNew(summary.getTeaser(), "", "");
            result = StoryPersistence.getStoryRepository().addScene(sceneToAdd);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        return result;
    }

    @GET
    @Path("{key}")
    public Scene get(@PathParam("key") String key) {
        return StoryPersistence.getStoryRepository().getScene(key);
    }

    @PUT
    @Path("{key}")
    public void update(@PathParam("key") String key, Scene sceneUpdate) {
        LOG.info("Receiving changes to scene.");
        if (!key.equals(sceneUpdate.getKey())) {
            LOG.error("Key in URI does not match key in data");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        StoryPersistence.getStoryRepository().updateScene(sceneUpdate);
    }

    @DELETE
    @Path("{key}")
    public void destroy(@PathParam("key") String key) {
        StoryPersistence.getStoryRepository().removeScene(key);
    }
}
