package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;

/**
 * <code>StoryRepository</code> defines the behavior for storing and retrieving stories.
 */
public interface StoryRepository {

    /**
     * Finds story in repository based on key.
     *
     * @param key
     * @return the instance of Story or null if not found
     */
    public Story getStory(String key);

    /**
     * Places a story in the repository.
     *
     * @param storyToAdd
     * @return key that story was assigned
     */
    public String registerStory(Story storyToAdd);

}
