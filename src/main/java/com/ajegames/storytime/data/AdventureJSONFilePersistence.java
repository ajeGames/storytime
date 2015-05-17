package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmount on 5/17/15.
 */
public class AdventureJSONFilePersistence implements AdventurePersistence {

    private static final String DEFAULT_FILEROOT = "adventure-files/";

    private static Logger LOG = LoggerFactory.getLogger(AdventureJSONFilePersistence.class);

    private File pathToFiles;

    public AdventureJSONFilePersistence() {
        this(DEFAULT_FILEROOT);
    }

    public AdventureJSONFilePersistence(String pathToFiles) {
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

    @Override
    public List<Adventure> loadAdventures() {
        List<Adventure> out = new ArrayList<Adventure>();
        File[] files = pathToFiles.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    Adventure loadedStory = new ObjectMapper().readValue(file, Adventure.class);
                    out.add(loadedStory);
                } catch (IOException e) {
                    LOG.error("File could not be read as Adventure: " + file.toString(), e);
                }
            }
        }
        return out;
    }

    @Override
    public void saveAdventure(Adventure adventure) {
        try {
            new ObjectMapper().writeValue(buildFilename(adventure.getKey()), adventure);
        } catch (IOException e) {
            LOG.error("Something went wrong when writing out the adventure", e);
        }
    }

    private File buildFilename(String baseName) {
        return new File(pathToFiles, baseName + ".json");
    }

    @Override
    public boolean deleteAdventure(Adventure adventure) {
        File fileToDelete = buildFilename(adventure.getKey());
        return fileToDelete.delete();
    }
}
