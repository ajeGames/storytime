package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.Storybook;
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
    private Map<String, Storybook> stories;
    private StoryTimePersistence storage;

    /**
     * One source of truth to hold all of the stories.
     *
     * @return StoryTimeRepository singleton
     */
    public static StoryTimeRepository getInstance() {
        if (instance == null) {
            instance = new StoryTimeRepository();
        }
        return instance;
    }

    private StoryTimeRepository() {
        this.keyGenerator = new RandomString(8);
        this.stories = new HashMap<String, Storybook>();
        this.storage = new NoopStoryTimePersistence();
    }

    /**
     * For injecting persistence mechanism.
     *
     * @param persistenceImpl
     */
    public void setPersistence(StoryTimePersistence persistenceImpl) {
        LOG.info("Setting persistence mechanism");
        if (persistenceImpl == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        this.storage = persistenceImpl;
        loadStories();
    }

    /**
     * Creates and persists new, empty storybook with a unique key, ready to be populated with an intriguing adventure.
     *
     * @return freshly minted Storybook
     */
    synchronized public Storybook createStorybook() {
        String tempKey;
        do {
            tempKey = keyGenerator.nextKey();
        } while (stories.containsKey(tempKey));

        Storybook book = new Storybook(tempKey);
        saveStory(book);
        return book;
    }

    public void loadStories() {
        List<Story> stories = storage.loadStories();
        LOG.info("Loading " + stories.size() + " stories");
        for (Story story : stories) {
            addStory(new Storybook().load(story));
        }
    }

    public void saveStory(Storybook book) {
        LOG.info("Saving story: " + book.getSummary().getKey());
        this.stories.put(book.getSummary().getKey(), book);
        this.storage.saveStory(book.getStory());
    }

    public void addStory(Storybook book) {
        LOG.info("Adding story: " + book.getSummary().getKey());
        stories.put(book.getSummary().getKey(), book);
    }

    public Storybook getStorybook(String storyKey) {
        return stories.get(storyKey);
    }

    public void deleteStory(String storyKey) {
        LOG.info("Deleting story: " + storyKey);
        storage.deleteStory(storyKey);
        stories.remove(storyKey);
    }

    public List<Storybook> getAllStorybooks() {
        LOG.info("Retrieving full list of stories");
        List<Storybook> all = new ArrayList<Storybook>();
        all.addAll(stories.values());
        return all;
    }
}
