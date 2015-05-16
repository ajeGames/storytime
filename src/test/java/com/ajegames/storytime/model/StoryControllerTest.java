package com.ajegames.storytime.model;

import com.ajegames.storytime.data.AdventureRepository;
import com.ajegames.storytime.data.StoryPersistence;
import com.ajegames.storytime.data.StoryRepository;
import org.testng.annotations.Test;

/**
 * Created by dmount on 5/16/15.
 */
public class StoryControllerTest {

    @Test
    public void createStoryWithOneChapter() {
        Adventure adv = Adventure.createNew("foo", "bar", "baz", "qux");

    }
}
