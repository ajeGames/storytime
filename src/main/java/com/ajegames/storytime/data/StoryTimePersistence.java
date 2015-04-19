package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StoryTimePersistence {

    private static Logger LOG = LoggerFactory.getLogger(StoryTimePersistence.class);

    private static final StoryTimePersistence persistence = new StoryTimePersistence();

    private static File STORY_DB_FILEROOT = new File("sdb/");

    public static StoryTimePersistence getInstance() {
        return persistence;
    }

    public void saveStoriesToDisk() {
        List<Story> allStories = StoryTimeRepository.getInstance().getStories();
        for (Story aStory : allStories) {
            try {
                File filename = new File(STORY_DB_FILEROOT + aStory.getKey() + ".json");
                writeStoryToFile(filename, aStory);
            } catch (IOException e) {
                LOG.error("Something went wrong when writing out the story", e);
            }
        }
    }

    private void writeStoryToFile(File storyFile, Story story) throws IOException {
        new ObjectMapper().writeValue(storyFile, story);
    }

    public void loadStoriesFromDisk() throws IOException {
        if (!STORY_DB_FILEROOT.exists()) {
            LOG.error("Cannot find story data files.");
            throw new IOException("Cannot find story data files.");
        }

        File[] storyDataFiles = STORY_DB_FILEROOT.listFiles();
        for (File datafile : storyDataFiles) {
            loadStoryFromFile(datafile);
        }
    }

    private void loadStoryFromFile(File datafile) {
        try {
            Story theStory = new ObjectMapper().readValue(datafile, Story.class);
            StoryTimeRepository.getInstance().addStory(theStory);
        } catch (IOException e) {
            LOG.error("Something went wrong when reading the story", e);
        } catch (Exception e) {
            LOG.error("Something went wrong", e);
        }
    }
}
