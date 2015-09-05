package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import com.ajegames.storytime.model.Storybook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    /**
     * Returns all story summaries found in repository.
     *
     * @return List of StorySummary
     */
    public List<StorySummary> getAllStorySummaries() {
        LOG.info("Fetching all stories in repository");

        List<Storybook> stories = repo.getAllStorybooks();
        List<StorySummary> results = new ArrayList<StorySummary>(stories.size());
        for (Storybook book : stories) {
            results.add(book.getSummary());
        }
        return results;
    }
}
