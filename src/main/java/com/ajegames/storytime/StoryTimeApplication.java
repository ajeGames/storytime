package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.health.StoryHealthCheck;
import com.ajegames.storytime.model.SceneSummary;
import com.ajegames.storytime.model.Story;
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
        bootstrap.addBundle(new AssetsBundle("/webui/", "/", "index.html"));
        loadSampleStories();
    }

    private void loadSampleStories() {
        StoryTimeRepository storyRepo = StoryTimeRepository.getInstance();
        try {
            storyRepo.addStory(Story.create("A Tall Tale", "A. Storyteller", "You will never believe it.",
                    SceneSummary.create("A man walks into a bar...")));
            storyRepo.addStory(Story.create("The Three Little Pigs", "Bros. Grimm", "A lesson in economics.",
                    SceneSummary.create("Who's afraid of the Big Bad Wolf?")));
        } catch (Exception e) {
            LOG.error("Unable to load sample stories", e);
        }
    }

    @Override
    public void run(StoryTimeConfiguration config, Environment environment) throws Exception {
        environment.healthChecks().register("story", new StoryHealthCheck());
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new StoryTimeResource());
        environment.jersey().register(new StoryResource());
    }
}
