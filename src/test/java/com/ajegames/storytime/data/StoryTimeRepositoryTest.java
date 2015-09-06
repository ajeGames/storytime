package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Storybook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests the repository which holds the Storybook instances and deals with persistence.
 */
public class StoryTimeRepositoryTest {

    private static StoryTimeRepository repo = null;
    private static StoryTimePersistenceTestMock persistenceMock = new StoryTimePersistenceTestMock();

    @BeforeClass
    public void setup() {
        repo = StoryTimeRepository.getInstance();
        repo.setPersistence(persistenceMock);
    }

    @Test
    public void testGetInstance() {
        // repo is singleton
        StoryTimeRepository test = StoryTimeRepository.getInstance();
        Assert.assertEquals(test, repo);
    }

    @Test
    public void testCreateStorybook() {
        Storybook book = repo.createStorybook();
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getStoryKey());  // make sure key is set

        Storybook test = repo.getStorybook(book.getStoryKey());
        Assert.assertEquals(test, book);

        Assert.assertTrue(persistenceMock.hasStory(book.getStoryKey()));
    }

    @Test
    public void testSaveEmptyStorybook() {
        Storybook book = repo.createStorybook();  // creates with new key; also saves
        repo.saveStory(book);  // make sure can be saved again
    }

    @Test
    public void testSaveStoryWithoutKey() {
        try {
            repo.saveStory(new Storybook());
        } catch (IllegalArgumentException e) {
            // success
            return;
        }
        Assert.fail();
    }

    @Test
    public void testLoadStory() {

    }

    @Test
    public void testDeleteStory() {

    }

    @Test
    public void testGetAllStorybooks() {

    }
}
