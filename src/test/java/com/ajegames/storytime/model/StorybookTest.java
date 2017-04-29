package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedSet;

/**
 * Test Storybook, which is the dynamic center of the model.
 */
public class StorybookTest {

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

        StorySummary update = StorySummary.create(testSummary.getKey(), "update", "update", "update", "update", 9999);
        bookOut.setSummary(update);

        Assert.assertEquals(bookOut.getSummary(), update);
    }

    @Test
    public void testGetFirstChapter() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        Assert.assertNotNull(bookOut.getFirstChapter());
    }

    @Test
    public void testAddChapterIncrementsChapterNumber() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);

        Chapter chapterA = bookOut.addChapter();
        Chapter chapterB = bookOut.addChapter();
        Chapter chapterC = bookOut.addChapter();
        Assert.assertEquals(chapterB.getId().intValue(), chapterA.getId() + 1);
        Assert.assertEquals(chapterC.getId().intValue(), chapterB.getId() + 1);
    }

    @Test
    public void testGetChapters() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);

        SortedSet<Chapter> chapters = bookOut.getChapters();
        Assert.assertEquals(chapters.size(), 3);  // all accounted for?

        // sorted properly?
        int previousChapter = 0;
        for (Chapter next : chapters) {
            Assert.assertTrue(previousChapter < next.getId());
            previousChapter = next.getId();
        }
    }

    @Test
    public void testUpdateChapter() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        int chapterCount = bookOut.getChapters().size();
        Chapter first = bookOut.getFirstChapter();
        Chapter update = Chapter.create(first.getId(), "update", "update", first.getNextChapterOptions());
        bookOut.updateChapter(update);
        Assert.assertEquals(bookOut.getChapter(first.getId()), update);
        Assert.assertEquals(bookOut.getChapters().size(), chapterCount);
    }

    @Test
    public void testUpdateChapterFailsWhenChapterNotFound() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        Chapter first = bookOut.getFirstChapter();
        Chapter update = Chapter.create(10001, "update", "update", first.getNextChapterOptions());
        try {
            bookOut.updateChapter(update);
        } catch (Exception e) {
            // success
            return;
        }
        Assert.fail();
    }

    @Test
    public void testUpdateChapterFailsWithNull() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        Chapter first = bookOut.getFirstChapter();
        Chapter update = Chapter.create(null, "update", "update", first.getNextChapterOptions());
        try {
            bookOut.updateChapter(update);
        } catch (Exception e) {
            // success
            return;
        }
        Assert.fail();
    }

    @Test
    public void testUpdateChapterFailsWhenChapterIsNull() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        try {
            bookOut.updateChapter(null);
        } catch (Exception e) {
            // success
            return;
        }
        Assert.fail();
    }

    @Test
    public void testAddNextChapterOption() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);
        Chapter sourceChapter = bookOut.getFirstChapter();

        int numOptions = sourceChapter.getNextChapterOptions().size();
        Chapter updatedSourceChapter = bookOut.addNextChapterOption(sourceChapter.getId(), "Choose Me");

        Assert.assertNotNull(updatedSourceChapter);
        Assert.assertEquals(updatedSourceChapter.getNextChapterOptions().size(), numOptions + 1);
        for (ChapterSign sign : updatedSourceChapter.getNextChapterOptions()) {
            if (sign.getTeaser().equals("Choose Me")) {
                Assert.assertNotNull(sign.getTargetChapterId());
                Assert.assertNotNull(bookOut.getChapter(sign.getTargetChapterId()));
                return;
            }
        }
        Assert.fail();
    }

    @Test
    public void testDeleteChapter() {
        Story testStory = StoryTestUtil.generateSimpleNonTrivialStory();
        Storybook bookOut = Storybook.load(testStory);

        Assert.assertEquals(bookOut.getChapters().size(), 3);
        Assert.assertEquals(bookOut.getFirstChapter().getNextChapterOptions().size(), 2);

        bookOut.deleteChapter(1002);
        Assert.assertNull(bookOut.getChapter(1002));
        Assert.assertEquals(bookOut.getChapters().size(), 2);
        Assert.assertEquals(bookOut.getFirstChapter().getNextChapterOptions().size(), 1);
        Assert.assertEquals(bookOut.getFirstChapter().getNextChapterOptions().get(0).getTargetChapterId().intValue(), 1001);
    }

}
