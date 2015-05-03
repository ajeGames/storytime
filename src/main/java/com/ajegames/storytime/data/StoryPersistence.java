package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StoryPersistence {

    private static final String DEFAULT_STORY_DB_FILEROOT = "story-files-default/";

    private static StoryPersistence instance;
    private static Logger LOG = LoggerFactory.getLogger(StoryPersistence.class);

    private File pathToStories;
    private StoryRepository repo;

    // hide from the outside
    private StoryPersistence(String pathToStoryFiles) {
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

        this.repo = new StoryRepository();
    }

    public static synchronized void initialize (String path) throws Exception {
        if (instance != null) {
            LOG.warn("Reinitializing...was that intentional?");
        }
        instance = new StoryPersistence(path);
        try {
            instance.loadStoryRepo();
        } catch (IOException e) {
            throw new Exception("Initialization failure: trouble loading repository.", e);
        }
    }

    /**
     * Removes the repository instance to start from a clean slate.
     *
     * <b>Primarily for testing.</b>
     */
    static void reset() {
        instance = null;
    }

    /**
     * Deletes the repository, including the directory and all story files that happen to be in it.  Also
     * removes the instance to start from a clean slate.
     *
     * <b>Primarily for testing.</b>
     */
    static void cleanup() {
        if (instance.pathToStories.exists()) {
            instance.pathToStories.delete();
        }
        instance.pathToStories = null;
        reset();
    }

    public static StoryPersistence getInstance() {
        if (instance == null) {
            LOG.warn("Initializing persistence using default path to story files: " + DEFAULT_STORY_DB_FILEROOT);
            try {
                initialize(DEFAULT_STORY_DB_FILEROOT);
            } catch (Exception e) {
                LOG.error("Could not establish instance", e);

                // better than returning null or forcing check for exceptions?
                throw new RuntimeException("Unable to get story repository");
            }
        }
        return instance;
    }

    public static StoryRepository getStoryRepository() {
        return getInstance().repo;
    }

    private void loadStoryRepo() throws IOException {
        if (repoPathIsValid()) {
            File[] storyDataFiles = pathToStories.listFiles();
            if (storyDataFiles != null) {
                for (File datafile : storyDataFiles) {
                    loadStoryFile(datafile);
                }
            }
        } else {
            throw new IOException("Cannot find path to story files.");
        }
    }

    private void loadStoryFile(File datafile) throws IOException {
        try {
            StoryGraph theWholeStory = new ObjectMapper().readValue(datafile, StoryGraph.class);
            repo.loadStory(theWholeStory.getStory());
        } catch (Exception e) {
            LOG.warn("Something went wrong loading file: " + datafile.getPath(), e);
        }
    }

    private boolean repoPathIsValid() {
        return this.pathToStories.exists() && this.pathToStories.isDirectory();
    }

    public void storeStoryRepo() {
        List<Story> allStories = repo.getStories();
        for (Story aStory : allStories) {
            try {
                File filename = new File(pathToStories + aStory.getKey() + ".json");
                writeStoryToFile(filename, aStory);
            } catch (IOException e) {
                LOG.error("Something went wrong when writing out the story", e);
            }
        }
    }

    private void writeStoryToFile(File storyFile, Story story) throws IOException {
        new ObjectMapper().writeValue(storyFile, story);
    }

}
