package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;

/**
 * <code>StoryRepository</code> defines the behavior for storing and retrieving stories.
 */
public interface StoryRepository {

    public Story getStory(String key);

}
