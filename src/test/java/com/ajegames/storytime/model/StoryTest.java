package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * For testing <code>Story</code>.
 */
public class StoryTest {

    @Test
    public void testCreateStory() {
        String title = "Peter Rabbit";
        String author = "Beatrix Potter";
        String description = "The tale of an adventurous little bunny and the dangerous life he led.";

        Story result = Story.createStory(title, author, description);

        Assert.assertEquals(result.getTitle(), title, "Title did not match:");
        Assert.assertEquals(result.getAuthor(), author, "Author did not match:");
        Assert.assertEquals(result.getDescription(), description, "Description did not match:");
        Assert.assertNotNull(result.getFirstScene(), "First scene ought to be populated:");
    }
}
