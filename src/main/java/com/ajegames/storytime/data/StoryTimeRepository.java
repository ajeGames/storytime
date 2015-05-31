package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryTimeRepository {

    private static StoryTimeRepository instance;
    private static Logger LOG = LoggerFactory.getLogger(StoryTimeRepository.class);

    private RandomString keyGenerator;
    private Map<String, Story> stories;
    private StoryTimePersistence storage;

    public static StoryTimeRepository getInstance() {
        if (instance == null) {
            instance = new StoryTimeRepository();
        }
        return instance;
    }

    private StoryTimeRepository() {
        this.keyGenerator = new RandomString(8);
        this.stories = new HashMap<String, Story>();
        this.storage = new NoopStoryTimePersistence();
    }

    public void setPersistence(StoryTimePersistence persistenceImpl) {
        LOG.info("Setting persistence mechanism");
        if (persistenceImpl == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        this.storage = persistenceImpl;
        loadStories();
    }

    public void loadStories() {
        List<Story> stories = storage.loadStories();
        LOG.info("Loading " + stories.size() + " stories");
        for (Story story : stories) {
            addStory(story);
            story.indexChapters();
        }
    }

    public void saveStory(String key) {
        LOG.info("Saving story: " + key);
        Story story = getStory(key);
        this.storage.saveStory(story);
    }

    public Story addStory(Story story) {
        LOG.info("Adding story: " + story.getKey());
        // assign key if needed
        String tempKey = story.getKey();
        if (tempKey == null) {
            do {
                tempKey = keyGenerator.nextKey();
            } while (stories.containsKey(tempKey));
            story.setKey(tempKey);
        }
        stories.put(tempKey, story);
        return story;
    }

    public Story getStory(String key) {
        return stories.get(key);
    }

    public void deleteStory(String key) {
        LOG.info("Deleting story: " + key);
        storage.deleteStory(getStory(key));
        stories.remove(key);
    }

    public List<Story> getAllStories() {
        LOG.info("Retrieving full list of stories");
        List<Story> all = new ArrayList<Story>();
        all.addAll(stories.values());
        return all;
    }
}
