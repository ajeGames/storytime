package com.ajegames.storytime;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This is for...
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

    }
}
