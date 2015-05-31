package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the implementation of persistence that is meant for production.
 */
public class JSONFileAdventurePersistence implements AdventurePersistence {

    private static final String DEFAULT_FILEROOT = "adventure-files/";

    private static Logger LOG = LoggerFactory.getLogger(JSONFileAdventurePersistence.class);

    private File pathToFiles;

    public JSONFileAdventurePersistence() {
        this(DEFAULT_FILEROOT);
    }

    public JSONFileAdventurePersistence(String pathToFiles) {
        this.pathToFiles = new File(pathToFiles);
        if (!this.pathToFiles.exists()) {
            LOG.info("Creating directory to hold story files.");
            if (!this.pathToFiles.mkdir()) {
                throw new RuntimeException("Unable to create path for story files.");
            }
        } else if (!this.pathToFiles.isDirectory()) {
            LOG.error("Path to adventure files must point to a directory. " + pathToFiles);
            throw new RuntimeException("Path to adventure files must point to a directory. " + pathToFiles);
        }
    }

    public List<Story> loadAdventures() {
        List<Story> out = new ArrayList<Story>();
        File[] files = pathToFiles.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    Story loadedStory = new ObjectMapper().readValue(file, Story.class);
                    out.add(loadedStory);
                } catch (IOException e) {
                    LOG.error("File could not be read as Story: " + file.toString(), e);
                }
            }
        }
        return out;
    }

    public void saveAdventure(Story story) {
        try {
            new ObjectMapper().writeValue(buildFilename(story.getKey()), story);
        } catch (IOException e) {
            LOG.error("Something went wrong when writing out the story", e);
        }
    }

    private File buildFilename(String baseName) {
        return new File(pathToFiles, baseName + ".json");
    }

    public boolean deleteAdventure(Story story) {
        File fileToDelete = buildFilename(story.getKey());
        return fileToDelete.delete();
    }
}
