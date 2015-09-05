package com.ajegames.storytime;

import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests methods for handling story creation, retrieval and updates.
 */
public class StoryControllerTest {

    private StoryController ctrl;

    @BeforeClass
    public void setup() {
        ctrl = new StoryController();
    }

    @Test
    public void testCreateStory() {
        StorySummary summary = ctrl.createStory(StorySummary.createUnregistered("foo", "bar", "baz", "qux"));
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
        StorySummary adv1 = ctrl.createStory(StorySummary.createUnregistered("one", "one", "one", "one"));
        StorySummary adv2 = ctrl.createStory(StorySummary.createUnregistered("two", "two", "two", "two"));

        Assert.assertNotNull(ctrl.getStory(adv1.getKey()));
        Assert.assertNotNull(ctrl.getStory(adv2.getKey()));
    }

    @Test
    public void testUpdateStory() {
        StorySummary adv = ctrl.createStory(StorySummary.createUnregistered("three", "three", "three", "three"));
        StorySummary update = StorySummary.create(adv.getKey(), "updated", );
        update.setKey(adv.getKey());
        update.setTitle("updated");
        update.setAuthor("updated");
        update.setTagLine("updated");
        update.setAbout("updated");
        ctrl.updateSummary(update);
        StorySummary result = ctrl.getStory(update.getKey()).getSummary();
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getAbout(), "updated");

        StorySummary check = ctrl.getStory(adv.getKey()).getSummary();
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

//    @Test
//    public void testUpdateStoryTitle() {
//        Story adv = ctrl.createStory("three", "three", "three", "three");
//        Story update = new Story();
//        update.setKey(adv.getKey());
//        update.setTitle("updated");
//        Story result = ctrl.updateSummary(update);
//        Assert.assertEquals(result.getTitle(), "updated");
//        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
//        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
//        Assert.assertEquals(result.getAbout(), adv.getAbout());
//
//        Story check = ctrl.getStory(adv.getKey());
//        Assert.assertEquals(check, result, "Return value should match stored value");
//    }
//
//    @Test
//    public void testUpdateStoryAuthor() {
//        Story adv = ctrl.createStory("three", "three", "three", "three");
//        Story update = new Story();
//        update.setKey(adv.getKey());
//        update.setAuthor("updated");
//        Story result = ctrl.updateSummary(update);
//        Assert.assertEquals(result.getTitle(), adv.getTitle());
//        Assert.assertEquals(result.getAuthor(), "updated");
//        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
//        Assert.assertEquals(result.getAbout(), adv.getAbout());
//
//        Story check = ctrl.getStory(adv.getKey());
//        Assert.assertEquals(check, result, "Return value should match stored value");
//    }
//
//    @Test
//    public void testUpdateStoryTagLine() {
//        Story adv = ctrl.createStory("three", "three", "three", "three");
//        Story update = new Story();
//        update.setKey(adv.getKey());
//        update.setTagLine("updated");
//        Story result = ctrl.updateSummary(update);
//        Assert.assertEquals(result.getTitle(), adv.getTitle());
//        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
//        Assert.assertEquals(result.getTagLine(), "updated");
//        Assert.assertEquals(result.getAbout(), adv.getAbout());
//
//        Story check = ctrl.getStory(adv.getKey());
//        Assert.assertEquals(check, result, "Return value should match stored value");
//    }
//
//    @Test
//    public void testUpdateStoryDescription() {
//        Story adv = ctrl.createStory("three", "three", "three", "three");
//        Story update = new Story();
//        update.setKey(adv.getKey());
//        update.setAbout("updated");
//        Story result = ctrl.updateSummary(update);
//        Assert.assertEquals(result.getTitle(), adv.getTitle());
//        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
//        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
//        Assert.assertEquals(result.getAbout(), "updated");
//
//        Story check = ctrl.getStory(adv.getKey());
//        Assert.assertEquals(check, result, "Return value should match stored value");
//    }
//
//    @Test
//    public void testGetChapter() {
//        Story adv = ctrl.createStory("four", "four", "four", "four");
//        Chapter chap = adv.getFirstChapter();
//
//        Chapter chapterFound = ctrl.getChapter(adv.getKey(), chap.getId());
//        Assert.assertNotNull(chapterFound);
//        Assert.assertNull(chapterFound.getTeaser());
//        Assert.assertNull(chapterFound.getHeading());
//        Assert.assertNull(chapterFound.getProse());
//    }
//
//    @Test
//    public void testUpdateChapter() {
//        Story story = ctrl.createStory("five", "five", "five", "five");
//        Chapter chap = story.getFirstChapter();
//
//        Chapter update = new Chapter();
//        update.setId(chap.getId());
//        update.setTeaser("update");
//        update.setHeading("update");
//        update.setProse("update");
//
//        Chapter result = ctrl.updateChapter(story.getKey(), update);
//        Assert.assertEquals(result.getTeaser(), "update");
//        Assert.assertEquals(result.getHeading(), "update");
//        Assert.assertEquals(result.getProse(), "update");
//
//        Chapter check = ctrl.getChapter(story.getKey(), chap.getId());
//        Assert.assertEquals(check, result);
//    }
//
//    @Test
//    public void testUpdateChapterTeaser() {
//        Story story = ctrl.createStory("five", "five", "five", "five");
//        Chapter chap = story.getFirstChapter();
//
//        Chapter update = new Chapter();
//        update.setId(chap.getId());
//        update.setTeaser("update");
//
//        Chapter result = ctrl.updateChapter(story.getKey(), update);
//        Assert.assertEquals(result.getTeaser(), "update");
//        Assert.assertEquals(result.getHeading(), chap.getHeading());
//        Assert.assertEquals(result.getProse(), chap.getProse());
//
//        Chapter check = ctrl.getChapter(story.getKey(), chap.getId());
//        Assert.assertEquals(check, result);
//    }
//
//    @Test
//    public void testUpdateChapterHeading() {
//        Story story = ctrl.createStory("five", "five", "five", "five");
//        Chapter chap = story.getFirstChapter();
//
//        Chapter update = new Chapter();
//        update.setId(chap.getId());
//        update.setHeading("update");
//
//        Chapter result = ctrl.updateChapter(story.getKey(), update);
//        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
//        Assert.assertEquals(result.getHeading(), "update");
//        Assert.assertEquals(result.getProse(), chap.getProse());
//
//        Chapter check = ctrl.getChapter(story.getKey(), chap.getId());
//        Assert.assertEquals(check, result);
//    }
//
//    @Test
//    public void testUpdateChapterProse() {
//        Story story = ctrl.createStory("five", "five", "five", "five");
//        Chapter chap = story.getFirstChapter();
//
//        Chapter update = new Chapter();
//        update.setId(chap.getId());
//        update.setProse("update");
//
//        Chapter result = ctrl.updateChapter(story.getKey(), update);
//        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
//        Assert.assertEquals(result.getHeading(), chap.getHeading());
//        Assert.assertEquals(result.getProse(), "update");
//
//        Chapter check = ctrl.getChapter(story.getKey(), chap.getId());
//        Assert.assertEquals(check, result);
//    }
//
//    @Test
//    public void testCreateNextChapter() {
//        Story story = ctrl.createStory("six", "six", "six", "six");
//        Chapter first = story.getFirstChapter();
//        Chapter result = ctrl.addNextChapter(story.getKey(), first.getId(), "Choose me!");
//
//        first = ctrl.getStory(story.getKey()).getFirstChapter();
//        Chapter check = ctrl.getChapter(story.getKey(), result.getId());
//        Assert.assertNotNull(check);
//        Assert.assertNotNull(result);
//        Assert.assertEquals(check, result);
//        Assert.assertEquals(first.getNextChapterOptions().size(), 1);
//        Assert.assertEquals(first.getNextChapterOptions().get(0), result);
//    }
//
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

    @Test
    public void testDeleteChapter() {

    }
}
