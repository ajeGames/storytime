package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StoryTest {

    @Test
    public void testStoryCreation() {
        Story testStory = Story.create("title", "author", "tag", "description", "12345678");
        Assert.assertEquals(testStory.getTitle(), "title");
        Assert.assertEquals(testStory.getAuthor(), "author");
        Assert.assertEquals(testStory.getTagLine(), "tag");
        Assert.assertEquals(testStory.getDescription(), "description");
        Assert.assertEquals(testStory.getFirstScene(), "12345678");
    }
}
