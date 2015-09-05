package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Storybook;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the repository which holds the Storybook instances and deals with persistence.
 */
public class StoryTimeRepositoryTest {

    private StoryTimeRepository repo = StoryTimeRepository.getInstance();

    @Test
    public void testCreateStorybook() {
        Storybook book = repo.createStorybook();
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getStoryKey());  // make sure key is set

        Storybook test = repo.getStorybook(book.getStoryKey());
        Assert.assertEquals(test, book);
    }
}
