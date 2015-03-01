package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>StoryRepositoryInMemoryImpl</code> manages storage and retrieval of stories.
 */
public class StoryTimeRepository {

    private static Map<String, Story> stories = new HashMap<String, Story>();
    private static Map<String, Scene> scenes = new HashMap<String, Scene>();

    private RandomString keyGenerator = new RandomString(8);

    public static StoryTimeRepository repo = new StoryTimeRepository();

}
