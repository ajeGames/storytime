package com.ajegames.storytime;

import com.ajegames.storytime.data.JSONFileAdventurePersistence;
import com.ajegames.storytime.data.AdventureRepository;
import com.ajegames.storytime.health.StoryHealthCheck;
import com.ajegames.storytime.resource.*;
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
            AdventureRepository.getInstance().setPersistence(new JSONFileAdventurePersistence(config.getPath()));
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
        environment.jersey().register(new AdventureResource());
        environment.jersey().register(new ChapterResource());
    }
}
