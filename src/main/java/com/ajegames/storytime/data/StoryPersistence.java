package com.ajegames.storytime.data;

import java.util.List;

/**
 * Provides services for storing stories to some kind of persistence mechanism: flat file, database, etc.
 */
public interface StoryPersistence {

    /**
     * Pulls all of the stories that are stored in persistence into memory.
     * @return list of StoryGraph objects read from persistence
     */
    List<StoryGraph> loadStories();

    /**
     * Saves a story to persistent storage.
     * @param story StoryGraph to store
     */
    void saveStory(StoryGraph story);

    /**
     * Deletes a story and all associated parts.
     *
     * @param story The story to delete
     * @return true if story was deleted, otherwise false
     */
    boolean deleteStory(StoryGraph story);
}
