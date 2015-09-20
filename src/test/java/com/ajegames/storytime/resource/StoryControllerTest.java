package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryTimePersistenceTestMock;
import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests methods for handling story creation, retrieval and updates.
 */
public class StoryControllerTest {

    private StoryController ctrl;

    @BeforeMethod
    public void setup() {
        StoryTimeRepository repo = StoryTimeRepository.create();
        repo.setPersistence(new StoryTimePersistenceTestMock());
        ctrl = StoryController.createWithMockControllerForTesting(repo);
    }

    @Test
    public void testCreateStory() {
        StorySummary summary = ctrl.createStory(StoryTestUtil.createWithoutKey("foo", "bar", "baz", "qux"));
        Assert.assertNotNull(summary.getKey());
        Assert.assertEquals(summary.getTitle(), "foo");
        Assert.assertEquals(summary.getAuthor(), "bar");
        Assert.assertEquals(summary.getTagLine(), "baz");
        Assert.assertEquals(summary.getAbout(), "qux");
        Assert.assertNotNull(summary.getFirstChapter());
        Assert.assertNotNull(summary.getFirstChapter().getTargetChapterId());
    }

    @Test
    public void testGetStory() {
        StorySummary adv1 = ctrl.createStory(StoryTestUtil.createWithoutKey("one", "one", "one", "one"));
        StorySummary adv2 = ctrl.createStory(StoryTestUtil.createWithoutKey("two", "two", "two", "two"));

        Assert.assertNotNull(ctrl.getStory(adv1.getKey()));
        Assert.assertNotNull(ctrl.getStory(adv2.getKey()));
    }

    @Test
    public void testUpdateStory() {
        StorySummary adv = ctrl.createStory(StoryTestUtil.createWithoutKey("three", "three", "three", "three"));
        StorySummary update = StorySummary.create(adv.getKey(), "updated", "updated", "updated", "updated", null);
        ctrl.updateSummary(update);
        StorySummary result = ctrl.getStory(update.getKey()).getSummary();
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getAbout(), "updated");

        StorySummary check = ctrl.getStory(adv.getKey()).getSummary();
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testGetChapter() {
        StorySummary adv = ctrl.createStory(StoryTestUtil.createWithoutKey("four", "four", "four", "four"));
        Chapter chapterFound = ctrl.getFirstChapter(adv.getKey());
        Assert.assertNotNull(chapterFound);
    }

    @Test
    public void testUpdateChapter() {
        StorySummary story = ctrl.createStory(StoryTestUtil.createWithoutKey("five", "five", "five", "five"));
        Chapter chap = ctrl.getFirstChapter(story.getKey());

        List<ChapterSign> options = new ArrayList<ChapterSign>();
        options.add(ChapterSign.create(2000, "update"));
        options.add(ChapterSign.create(2001, "update"));
        Chapter update = Chapter.create(chap.getId(), "update", "update", options);
        ctrl.updateChapter(story.getKey(), update);

        Chapter result = ctrl.getFirstChapter(story.getKey());
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getHeading(), "update");
        Assert.assertEquals(result.getProse(), "update");
        Assert.assertEquals(result.getNextChapterOptions().size(), 2);
        Assert.assertEquals(result, update);
    }

    @Test
    public void testCreateNextChapter() {
        StorySummary story = ctrl.createStory(StoryTestUtil.createWithoutKey("six", "six", "six", "six"));
        Chapter first = ctrl.getFirstChapter(story.getKey());
        Chapter result = ctrl.addNextChapter(story.getKey(), first.getId(), "Choose me!");

        // check that source chapter was updated with new option
        Assert.assertNotNull(result);
        Assert.assertNotEquals(result, first);
        Assert.assertEquals(first.getNextChapterOptions().size(), 0);
        Assert.assertEquals(result.getNextChapterOptions().size(), 1);

        // make sure update was preserved, not just returned the first time
        Chapter updatedFirst = ctrl.getFirstChapter(story.getKey());
        Assert.assertEquals(updatedFirst, result);

        // check the sign to the new chapter
        ChapterSign newChapterSign = result.getNextChapterOptions().get(0);
        Assert.assertEquals(newChapterSign.getTeaser(), "Choose me!");

        // make sure new chapter exists
        Chapter newChapter = ctrl.getChapter(story.getKey(), newChapterSign.getTargetChapterId());
        Assert.assertNotNull(newChapter);
    }

    @Test
    public void testCreateChainOfNextChapters() {
        StorySummary story = ctrl.createStory(StoryTestUtil.createWithoutKey("seven", "seven", "seven", "seven"));
        String storyKey = story.getKey();

        Chapter node = ctrl.getFirstChapter(storyKey);
        for (int i=1; i <= 4; i++) {
            Assert.assertEquals(node.getNextChapterOptions().size(), 0);
            node = ctrl.addNextChapter(storyKey, node.getId(), "level " + i);
            Assert.assertEquals(node.getNextChapterOptions().size(), 1);
            node = ctrl.getChapter(storyKey, node.getNextChapterOptions().get(0).getTargetChapterId());
            Assert.assertNotNull(node);
        }
    }

    @Test
    public void testDeleteStory() {
        StorySummary story = ctrl.createStory(StoryTestUtil.createWithoutKey("eight", "eight", "eight", "eight"));
        Assert.assertNotNull(ctrl.getStory(story.getKey()));
        ctrl.deleteStory(story.getKey());
        Assert.assertNull(ctrl.getStory(story.getKey()));
    }

    @Test
    public void testDeleteChapter() {
        StorySummary story = ctrl.createStory(StoryTestUtil.createWithoutKey("eight", "eight", "eight", "eight"));
        Chapter sourceChapter = ctrl.addNextChapter(story.getKey(), ctrl.getFirstChapter(story.getKey()).getId(),
                "chapter two");
        Assert.assertEquals(sourceChapter.getNextChapterOptions().size(), 1);
        Chapter next = ctrl.getChapter(story.getKey(),
                sourceChapter.getNextChapterOptions().get(0).getTargetChapterId());
        Assert.assertNotNull(next);

        ctrl.deleteChapter(story.getKey(), next.getId());
        Assert.assertNull(ctrl.getChapter(story.getKey(), next.getId()));
    }
}
