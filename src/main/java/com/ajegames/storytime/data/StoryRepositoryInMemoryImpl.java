package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>StoryRepositoryInMemoryImpl</code> manages storage and retrieval of stories.
 */
public class StoryRepositoryInMemoryImpl implements StoryRepository {

    private static Map<String, Story> stories = new HashMap<String, Story>();

    // TODO use dependency injection to enable test for identical keys
    private RandomString keyGenerator = new RandomString(8);

    public static StoryRepository singleton = new StoryRepositoryInMemoryImpl();

    @Override
    public Story getStory(String key) {
        return stories.get(key);
    }

    @Override
    public String registerStory(Story storyToAdd) {
        String key;
        do {
            key = keyGenerator.nextString();
        } while (stories.containsKey(key));
        stories.put(key, storyToAdd);
        return key;
    }
}
