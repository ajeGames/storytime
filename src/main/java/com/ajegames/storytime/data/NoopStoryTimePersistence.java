package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NoopStoryTimePersistence implements StoryTimePersistence {

    private static Logger LOG = LoggerFactory.getLogger(NoopStoryTimePersistence.class);

    public List<Story> loadStories() {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return null;
    }

    public void saveStory(Story story) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
    }

    public boolean deleteStory(Story story) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return false;
    }
}