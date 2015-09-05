package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
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
            addStory(new Storybook().load(story));
        }
    }

    public void saveStory(Storybook book) {
        LOG.info("Saving story: " + book.getSummary().getKey());
        this.stories.put(book.getSummary().getKey(), book);
        this.storage.saveStory(book.getStory());
    }

    /**
     * Adds a new story to the repository, assigning a key in the process.
     * @param book whatever story details are known at the time
     * @return the story that was passed in, but with a newly minted key
     */
    public Storybook registerNewStory(Storybook book) {
        StorySummary summary = book.getSummary();
        if (summary.getKey() != null) {
            throw new IllegalArgumentException("Only call for new stories that need to have a key assigned");
        }
        LOG.info("Registering story: " + summary.getTitle());
        LOG.debug(book.toString());

        String tempKey;
        do {
            tempKey = keyGenerator.nextKey();
        } while (stories.containsKey(tempKey));

        // TODO push this onto Storybook class
        book.setSummary(StorySummary.create(tempKey, summary.getTitle(), summary.getAuthor(), summary.getTagLine(),
                summary.getAbout(), summary.getFirstChapter()));
        saveStory(book);
        return book;
    }

    public Storybook forgeNewStory() {
        String tempKey;
        do {
            tempKey = keyGenerator.nextKey();
        } while (stories.containsKey(tempKey));

        Storybook book = new Storybook();
        book.setKey(tempKey);
        saveStory(book);
        return book;
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
