package com.ajegames.storytime.model;

import com.ajegames.storytime.model.view.StandaloneChapter;
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
        Story adv = ctrl.createStory("foo", "bar", "baz", "qux");
        Assert.assertNotNull(adv.getKey());
        Assert.assertEquals(adv.getTitle(), "foo");
        Assert.assertEquals(adv.getAuthor(), "bar");
        Assert.assertEquals(adv.getTagLine(), "baz");
        Assert.assertEquals(adv.getDescription(), "qux");
        Assert.assertNotNull(adv.getFirstChapter());
        Assert.assertNotNull(adv.getFirstChapter().getId());
        Assert.assertNull(adv.getFirstChapter().getHeading());
    }

    @Test
    public void testGetStory() {
        Story adv1 = ctrl.createStory("one", "one", "one", "one");
        Story adv2 = ctrl.createStory("two", "two", "two", "two");

        Assert.assertNotNull(ctrl.getStory(adv1.getKey()));
        Assert.assertNotNull(ctrl.getStory(adv2.getKey()));
    }

    @Test
    public void testUpdateStory() {
        Story adv = ctrl.createStory("three", "three", "three", "three");
        Story update = new Story();
        update.setKey(adv.getKey());
        update.setTitle("updated");
        update.setAuthor("updated");
        update.setTagLine("updated");
        update.setDescription("updated");
        Story result = ctrl.updateStory(update);
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getDescription(), "updated");

        Story check = ctrl.getStory(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryTitle() {
        Story adv = ctrl.createStory("three", "three", "three", "three");
        Story update = new Story();
        update.setKey(adv.getKey());
        update.setTitle("updated");
        Story result = ctrl.updateStory(update);
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Story check = ctrl.getStory(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryAuthor() {
        Story adv = ctrl.createStory("three", "three", "three", "three");
        Story update = new Story();
        update.setKey(adv.getKey());
        update.setAuthor("updated");
        Story result = ctrl.updateStory(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Story check = ctrl.getStory(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryTagLine() {
        Story adv = ctrl.createStory("three", "three", "three", "three");
        Story update = new Story();
        update.setKey(adv.getKey());
        update.setTagLine("updated");
        Story result = ctrl.updateStory(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Story check = ctrl.getStory(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryDescription() {
        Story adv = ctrl.createStory("three", "three", "three", "three");
        Story update = new Story();
        update.setKey(adv.getKey());
        update.setDescription("updated");
        Story result = ctrl.updateStory(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), "updated");

        Story check = ctrl.getStory(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testGetChapter() {
        Story adv = ctrl.createStory("four", "four", "four", "four");
        Chapter chap = adv.getFirstChapter();

        StandaloneChapter chapterFound = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertNotNull(chapterFound);
        Assert.assertNull(chapterFound.getTeaser());
        Assert.assertNull(chapterFound.getHeading());
        Assert.assertNull(chapterFound.getProse());
    }

    @Test
    public void testUpdateChapter() {
        Story story = ctrl.createStory("five", "five", "five", "five");
        Chapter chap = story.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setTeaser("update");
        update.setHeading("update");
        update.setProse("update");

        Chapter result = ctrl.updateChapter(story.getKey(), update);
        Assert.assertEquals(result.getTeaser(), "update");
        Assert.assertEquals(result.getHeading(), "update");
        Assert.assertEquals(result.getProse(), "update");

        StandaloneChapter check = ctrl.getChapter(story.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterTeaser() {
        Story story = ctrl.createStory("five", "five", "five", "five");
        Chapter chap = story.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setTeaser("update");

        Chapter result = ctrl.updateChapter(story.getKey(), update);
        Assert.assertEquals(result.getTeaser(), "update");
        Assert.assertEquals(result.getHeading(), chap.getHeading());
        Assert.assertEquals(result.getProse(), chap.getProse());

        StandaloneChapter check = ctrl.getChapter(story.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterHeading() {
        Story story = ctrl.createStory("five", "five", "five", "five");
        Chapter chap = story.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setHeading("update");

        Chapter result = ctrl.updateChapter(story.getKey(), update);
        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
        Assert.assertEquals(result.getHeading(), "update");
        Assert.assertEquals(result.getProse(), chap.getProse());

        StandaloneChapter check = ctrl.getChapter(story.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterProse() {
        Story story = ctrl.createStory("five", "five", "five", "five");
        Chapter chap = story.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setProse("update");

        Chapter result = ctrl.updateChapter(story.getKey(), update);
        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
        Assert.assertEquals(result.getHeading(), chap.getHeading());
        Assert.assertEquals(result.getProse(), "update");

        Chapter check = ctrl.getChapter(story.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testCreateNextChapter() {
        Story story = ctrl.createStory("six", "six", "six", "six");
        Chapter first = story.getFirstChapter();
        Chapter result = ctrl.addNextChapter(story.getKey(), first.getId(), "Choose me!");

        first = ctrl.getStory(story.getKey()).getFirstChapter();
        Chapter check = ctrl.getChapter(story.getKey(), result.getId());
        Assert.assertNotNull(check);
        Assert.assertNotNull(result);
        Assert.assertEquals(check, result);
        Assert.assertEquals(first.getNextChapterOptions().size(), 1);
        Assert.assertEquals(first.getNextChapterOptions().get(0), result);
    }

    @Test
    public void testCreateChainOfNextChapters() {
        Story story = ctrl.createStory("seven", "seven", "seven", "seven");
        String storyKey = story.getKey();
        Chapter first = story.getFirstChapter();
        first.setTeaser("first level");
        Chapter second = ctrl.addNextChapter(storyKey, first.getId(), "second level");
        Chapter third= ctrl.addNextChapter(storyKey, second.getId(), "third level");
        Chapter fourth= ctrl.addNextChapter(storyKey, third.getId(), "fourth level");

        Chapter secondCheck = ctrl.getChapter(storyKey, second.getId());
        Chapter thirdCheck = ctrl.getChapter(storyKey, third.getId());
        Chapter fourthCheck = ctrl.getChapter(storyKey, fourth.getId());

        Assert.assertEquals(secondCheck, second);
        Assert.assertEquals(thirdCheck, third);
        Assert.assertEquals(fourthCheck, fourth);
    }

    @Test
    public void testDeleteStory() {
        Story story = ctrl.createStory("eigth", "eigth", "eigth", "eigth");
        Story check = ctrl.getStory(story.getKey());
        Assert.assertNotNull(check);

        ctrl.deleteStory(check.getKey());
        check = ctrl.getStory(story.getKey());
        Assert.assertNull(check);
    }

    @Test
    public void testDeleteChapter() {

    }
}
