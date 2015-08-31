package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    public List<StorySummary> getAllStories() {
        LOG.info("Fetching all stories in repository");

        List<Story> stories = repo.getAllStorybooks();
        List<StorySummary> results = new ArrayList<StorySummary>(stories.size());
        for (Story story : stories) {
            results.add(story.getSummary());
        }
        return results;
    }
}
