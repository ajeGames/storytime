package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryPersistence;
import com.ajegames.storytime.health.StoryHealthCheck;
import com.ajegames.storytime.resource.SceneResource;
import com.ajegames.storytime.resource.StoryResource;
import com.ajegames.storytime.resource.StoryTimeResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is what sets up the application.
 */
public class StoryTimeApplication extends Application<StoryTimeConfiguration> {

    private static Logger LOG = LoggerFactory.getLogger(StoryTimeApplication.class);

    public static void main(String[] args) throws Exception {
        new StoryTimeApplication().run(args);
    }

    @Override
    public String getName() {
        return "StoryTime";
    }

    @Override
    public void initialize(Bootstrap<StoryTimeConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/webui/", "/", "index-mockup.html"));
    }

    private void loadSampleStories(PersistenceConfiguration config) {
        try {
            StoryPersistence.initialize(config.getPath());
        } catch (Exception e) {
            LOG.error("Unable to load sample stories", e);
        }
    }

    @Override
    public void run(StoryTimeConfiguration config, Environment environment) throws Exception {
        loadSampleStories(config.getPersistence());
        environment.healthChecks().register("story", new StoryHealthCheck());
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new StoryTimeResource());
        environment.jersey().register(new StoryResource());
        environment.jersey().register(new SceneResource());
    }
}
