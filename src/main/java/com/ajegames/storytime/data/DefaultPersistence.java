package com.ajegames.storytime.data;

import java.io.IOException;
import java.util.List;

/**
 * For now, must initialize repository with persistence implementation before use, and this is a way to ensure
 * that happens.
 */
public class DefaultPersistence implements StoryPersistence {

    @Override
    public List<StoryGraph> loadStories() {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }

    @Override
    public void saveStory(StoryGraph story) {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }

    @Override
    public boolean deleteStory(StoryGraph story) {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }
}
