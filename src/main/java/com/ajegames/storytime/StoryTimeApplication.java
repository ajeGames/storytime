package com.ajegames.storytime;

import com.ajegames.storytime.health.StoryHealthCheck;
import com.ajegames.storytime.resource.StoryResource;
import com.ajegames.storytime.resource.StoryTimeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This is what sets up the application.
 */
public class StoryTimeApplication extends Application<StoryTimeConfiguration> {

    public static void main(String[] args) throws Exception {
        new StoryTimeApplication().run(args);
    }

    @Override
    public String getName() {
        return "StoryTime";
    }

    @Override
    public void initialize(Bootstrap<StoryTimeConfiguration> bootstrap) {

    }

    @Override
    public void run(StoryTimeConfiguration config, Environment environment) throws Exception {
        environment.healthChecks().register("story", new StoryHealthCheck());
        environment.jersey().register(new StoryTimeResource());
        environment.jersey().register(new StoryResource());
    }
}
