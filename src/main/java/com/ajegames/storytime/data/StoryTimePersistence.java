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

    public void saveStoriesToDisk() {
        List<Story> allStories = StoryTimeRepository.getInstance().getStories();
        for (Story aStory : allStories) {
            try {
                File filename = new File("sdb/" + aStory.getKey() + ".json");
                writeStoryToFile(filename, aStory);
            } catch (IOException e) {
                LOG.error("Something went wrong when writing out the story", e);
            }
        }
    }

    public void writeStoryToFile(File storyFile, Story story) throws IOException {
        new ObjectMapper().writeValue(storyFile, story);
    }

}
