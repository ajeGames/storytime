package com.ajegames.storytime.data;

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
            story.initializeAfterLoad();
        }
    }

    public void saveStory(Story storyToSave) {
        LOG.info("Saving story: " + storyToSave.getSummary().getKey());
        this.stories.put(storyToSave.getSummary().getKey(), storyToSave);
        this.storage.saveStory(storyToSave);
    }

    /**
     * Adds a new story to the repository, assigning a key in the process.
     * @param story whatever story details are known at the time
     * @return the story that was passed in, but with a newly minted key
     */
    public Story registerNewStory(Story story) {
        if (story.getSummary().getKey() != null) {
            throw new IllegalArgumentException("Only call for new stories that need to have a key assigned");
        }
        LOG.info("Registering story: " + story.getSummary().getTitle());
        LOG.debug(story.toString());

        String tempKey;
        do {
            tempKey = keyGenerator.nextKey();
        } while (stories.containsKey(tempKey));
        story.getSummary().setKey(tempKey);
        addStory(story);
        return story;
    }

    public void addStory(Story story) {
        LOG.info("Adding story: " + story.getSummary().getKey());
        stories.put(story.getSummary().getKey(), story);
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
