package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;

import java.util.List;

public interface AdventurePersistence {

    /**
     * Pulls all stories into memory.
     * @return list of Adventure objects read from persistence
     */
    List<Adventure> loadAdventures();

    /**
     * Saves to persistent storage.
     * @param adventure Adventure to store
     */
    void saveAdventure(Adventure adventure);

    /**
     * Deletes a story and all associated parts.
     *
     * @param adventure The story to delete
     * @return true if story was deleted, otherwise false
     */
    boolean deleteAdventure(Adventure adventure);
}
