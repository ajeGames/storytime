package com.ajegames.storytime.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileStoryPersistence implements StoryPersistence {

    private static final String DEFAULT_STORY_DB_FILEROOT = "story-files-default/";

    private static Logger LOG = LoggerFactory.getLogger(JSONFileStoryPersistence.class);

    private File pathToStories;

    public JSONFileStoryPersistence() {
        this(DEFAULT_STORY_DB_FILEROOT);
    }

    public JSONFileStoryPersistence(String pathToStoryFiles) {
        this.pathToStories = new File(pathToStoryFiles);
        if (!pathToStories.exists()) {
            LOG.info("Creating directory to hold story files.");
            if (!pathToStories.mkdir()) {
                throw new RuntimeException("Unable to createNew path for story files.");
            }
        } else if (!pathToStories.isDirectory()) {
            LOG.error("Path to story files must point to a directory. " + pathToStoryFiles);
            throw new RuntimeException("Path to story files must point to a directory. " + pathToStoryFiles);
        }
    }

    public List<StoryBundle> loadStories() {
        List<StoryBundle> out = new ArrayList<StoryBundle>();
        File[] storyDataFiles = pathToStories.listFiles();
        if (storyDataFiles != null) {
            for (File datafile : storyDataFiles) {
                try {
                    StoryBundle loadedStory = new ObjectMapper().readValue(datafile, StoryBundle.class);
                    out.add(loadedStory);
                } catch (IOException e) {
                    LOG.error("File could not be read as a story: " + datafile.toString());
                }
            }
        }
        return out;
    }

    public void saveStory(StoryBundle story) {
        try {
            new ObjectMapper().writeValue(buildFilename(story.getStory().getKey()), story);
        } catch (IOException e) {
            LOG.error("Something went wrong when writing out the story", e);
        }
    }

    public boolean deleteStory(StoryBundle story) {
        File fileToDelete = buildFilename(story.getStory().getKey());
        return fileToDelete.delete();
    }

    private File buildFilename(String baseName) {
        return new File(pathToStories, baseName + ".json");
    }

}
