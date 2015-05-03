package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StoryTest {

    @Test
    public void testNewStoryCreation() {
        Story testStory = Story.createNew("title", "author", "tag", "description");
        Assert.assertEquals(testStory.getTitle(), "title");
        Assert.assertEquals(testStory.getAuthor(), "author");
        Assert.assertEquals(testStory.getTagLine(), "tag");
        Assert.assertEquals(testStory.getDescription(), "description");
        Assert.assertNull(testStory.getKey());
        Assert.assertNull(testStory.getFirstScene());
    }

    @Test
    public void testExistingStoryCreation() {
        Story testStory = Story.createExisting("12345678", "title", "author", "tag", "description", "12345678");
        Assert.assertEquals(testStory.getKey(), "12345678");
        Assert.assertEquals(testStory.getTitle(), "title");
        Assert.assertEquals(testStory.getAuthor(), "author");
        Assert.assertEquals(testStory.getTagLine(), "tag");
        Assert.assertEquals(testStory.getDescription(), "description");
        Assert.assertEquals(testStory.getFirstScene(), "12345678");

    }
}
