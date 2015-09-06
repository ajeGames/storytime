package com.ajegames.storytime.data;

import com.ajegames.storytime.model.ChapterSign;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import com.ajegames.storytime.model.Storybook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Story> toLoad = new ArrayList<Story>();
        toLoad.add(
                Story.create(
                        StorySummary.create("loadStoryTest1", "title", "author", "tag line", "about",
                                ChapterSign.create(1000, "teaser")),
                        null));
        toLoad.add(
                Story.create(
                        StorySummary.create("loadStoryTest2", "title", "author", "tag line", "about",
                                ChapterSign.create(1000, "teaser")),
                        null));
        persistenceMock.setStoriesToLoad(toLoad);

        repo.loadStories();
        Assert.assertNotNull(repo.getStorybook("loadStoryTest1"));
        Assert.assertNotNull(repo.getStorybook("loadStoryTest2"));
    }

    @Test
    public void testDeleteStory() {
        Storybook book = repo.createStorybook();
        String testKey = book.getStoryKey();
        Assert.assertNotNull(repo.getStorybook(testKey));
        Assert.assertTrue(persistenceMock.hasStory(testKey));

        repo.deleteStory(testKey);
        Assert.assertNull(repo.getStorybook(testKey));
        Assert.assertFalse(persistenceMock.hasStory(testKey));
    }

    @Test
    public void testGetAllStorybooks() {
        Storybook book1 = repo.createStorybook();
        Storybook book2 = repo.createStorybook();
        Storybook book3 = repo.createStorybook();
        Storybook book4 = repo.createStorybook();
        List<Storybook> books = repo.getAllStorybooks();
        Assert.assertTrue(books.contains(book1));
        Assert.assertTrue(books.contains(book2));
        Assert.assertTrue(books.contains(book3));
        Assert.assertTrue(books.contains(book4));
    }
}
