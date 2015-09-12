package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryTimePersistenceTestMock;
import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.ChapterSign;
import com.ajegames.storytime.model.StorySummary;
import com.ajegames.storytime.model.StoryTestUtil;
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
        Assert.assertNotNull(result);

        Chapter updatedFirst = ctrl.getFirstChapter(story.getKey());
        Assert.assertEquals(updatedFirst.getNextChapterOptions().size(), 1);
        Assert.assertEquals(updatedFirst.getNextChapterOptions().get(0).getTargetChapterId(), result.getId());

        Chapter check = ctrl.getChapter(story.getKey(), result.getId());
        Assert.assertNotNull(check);
        Assert.assertEquals(check, result);
    }

//    @Test
//    public void testCreateChainOfNextChapters() {
//        Story story = ctrl.createStory("seven", "seven", "seven", "seven");
//        String storyKey = story.getKey();
//        Chapter first = story.getFirstChapter();
//        first.setTeaser("first level");
//        Chapter second = ctrl.addNextChapter(storyKey, first.getId(), "second level");
//        Chapter third= ctrl.addNextChapter(storyKey, second.getId(), "third level");
//        Chapter fourth= ctrl.addNextChapter(storyKey, third.getId(), "fourth level");
//
//        Chapter secondCheck = ctrl.getChapter(storyKey, second.getId());
//        Chapter thirdCheck = ctrl.getChapter(storyKey, third.getId());
//        Chapter fourthCheck = ctrl.getChapter(storyKey, fourth.getId());
//
//        Assert.assertEquals(secondCheck, second, "second");
//        Assert.assertEquals(thirdCheck, third, "third");
//        Assert.assertEquals(fourthCheck, fourth, "fourth");
//    }
//
//    @Test
//    public void testDeleteStory() {
//        Story story = ctrl.createStory("eigth", "eigth", "eigth", "eigth");
//        Story check = ctrl.getStory(story.getKey());
//        Assert.assertNotNull(check);
//
//        ctrl.deleteStory(check.getKey());
//        check = ctrl.getStory(story.getKey());
//        Assert.assertNull(check);
//    }
//
//    @Test
//    public void testDeleteChapter() {
//
//    }
}
