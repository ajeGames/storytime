package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by dmount on 4/17/15.
 */
public class StoryTimePersistence {

    public static String FILEROOT = "sdb/";

    public void writeStoryToFile(Story story) throws IOException {
        new ObjectMapper().writeValue(new File(FILEROOT + story.getKey()), story);
    }
}
