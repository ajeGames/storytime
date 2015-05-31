package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;

import java.util.List;

public interface AdventurePersistence {

    /**
     * Pulls all stories into memory.
     * @return list of Story objects read from persistence
     */
    List<Story> loadAdventures();

    /**
     * Saves to persistent storage.
     * @param story Story to store
     */
    void saveAdventure(Story story);

    /**
     * Deletes a story and all associated parts.
     *
     * @param story The story to delete
     * @return true if story was deleted, otherwise false
     */
    boolean deleteAdventure(Story story);
}
