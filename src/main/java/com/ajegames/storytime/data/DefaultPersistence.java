package com.ajegames.storytime.data;

import java.util.List;

/**
 * For now, must initialize repository with persistence implementation before use, and this is a way to ensure
 * that happens.
 */
public class DefaultPersistence implements StoryPersistence {

    @Override
    public List<StoryBundle> loadStories() {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }

    @Override
    public void saveStory(StoryBundle story) {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }

    @Override
    public boolean deleteStory(StoryBundle story) {
        throw new IllegalStateException("Failed to initialize repository persistence");
    }
}
