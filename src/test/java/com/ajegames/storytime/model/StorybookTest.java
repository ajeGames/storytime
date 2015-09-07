package com.ajegames.storytime.model;

import com.ajegames.storytime.data.NoopStoryTimePersistence;
import com.ajegames.storytime.data.StoryTimeRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Storybook, which is the dynamic center of the model.
 */
public class StorybookTest {

    private StoryTimeRepository repo;

    @BeforeMethod
    public void setupEachTime() {
        // get a clean instance that is not the singleton to avoid problems with multithreading
        repo = StoryTimeRepository.create();
        repo.setPersistence(new NoopStoryTimePersistence());
    }

    @Test
    public void testLoadStory() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);

        Assert.assertEquals(bookOut.getStoryKey(), testStory.getSummary().getKey());
        Assert.assertEquals(bookOut.getSummary(), testStory.getSummary());
        Assert.assertEquals(bookOut.getChapters().size(), testStory.getChapters().size());
    }

    @Test
    public void testCreateInstanceWithKey() {
        Storybook testStory = Storybook.createWithKey("MYFANCYKEY");
        Assert.assertEquals(testStory.getStoryKey(), "MYFANCYKEY");
    }

    @Test
    public void testGetStory() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        Story testOut = bookOut.getStory();
        Assert.assertEquals(testOut, testStory);
    }

    @Test
    public void testUpdateStorySummary() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        StorySummary testSummary = testStory.getSummary();

        StorySummary update = StorySummary.create(testSummary.getKey(), "update", "update", "update", "update",
                ChapterSign.create(9999, "update"));
        bookOut.setSummary(update);

        Assert.assertEquals(bookOut.getSummary(), update);
    }

//    @Test
//    public void testAddChapterMultipleTimes() {
//
//    }
//
//    @Test
//    public void testUpdateChapter() {
//
//    }
//
//    @Test
//    public void testUpdateChapterNextChapterOptions() {
//
//    }
//
//    @Test
//    public void testDeleteChapter() {
//
//    }

    // helper methods

    private StoryTimeRepository createRepo() {
        return StoryTimeRepository.create();
    }

}
