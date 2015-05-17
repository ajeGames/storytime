package com.ajegames.storytime.model;

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
        Adventure adv = ctrl.createAdventure("foo", "bar", "baz", "qux");
        Assert.assertNotNull(adv.getKey());
        Assert.assertEquals(adv.getTitle(), "foo");
        Assert.assertEquals(adv.getAuthor(), "bar");
        Assert.assertEquals(adv.getTagLine(), "baz");
        Assert.assertEquals(adv.getDescription(), "qux");
        Assert.assertNotNull(adv.getFirstChapter());
        Assert.assertNotNull(adv.getFirstChapter().getId());
        Assert.assertNull(adv.getFirstChapter().getHeading());
        Assert.assertEquals(adv.getFirstChapter().getStory(), adv);
    }

    @Test
    public void testGetStory() {
        Adventure adv1 = ctrl.createAdventure("one", "one", "one", "one");
        Adventure adv2 = ctrl.createAdventure("two", "two", "two", "two");

        Assert.assertNotNull(ctrl.getAdventure(adv1.getKey()));
        Assert.assertNotNull(ctrl.getAdventure(adv2.getKey()));
    }

    @Test
    public void testUpdateStory() {
        Adventure adv = ctrl.createAdventure("three", "three", "three", "three");
        Adventure update = new Adventure();
        update.setKey(adv.getKey());
        update.setTitle("updated");
        update.setAuthor("updated");
        update.setTagLine("updated");
        update.setDescription("updated");
        Adventure result = ctrl.updateAdventure(update);
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getDescription(), "updated");

        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryTitle() {
        Adventure adv = ctrl.createAdventure("three", "three", "three", "three");
        Adventure update = new Adventure();
        update.setKey(adv.getKey());
        update.setTitle("updated");
        Adventure result = ctrl.updateAdventure(update);
        Assert.assertEquals(result.getTitle(), "updated");
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryAuthor() {
        Adventure adv = ctrl.createAdventure("three", "three", "three", "three");
        Adventure update = new Adventure();
        update.setKey(adv.getKey());
        update.setAuthor("updated");
        Adventure result = ctrl.updateAdventure(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), "updated");
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryTagLine() {
        Adventure adv = ctrl.createAdventure("three", "three", "three", "three");
        Adventure update = new Adventure();
        update.setKey(adv.getKey());
        update.setTagLine("updated");
        Adventure result = ctrl.updateAdventure(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), "updated");
        Assert.assertEquals(result.getDescription(), adv.getDescription());

        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testUpdateStoryDescription() {
        Adventure adv = ctrl.createAdventure("three", "three", "three", "three");
        Adventure update = new Adventure();
        update.setKey(adv.getKey());
        update.setDescription("updated");
        Adventure result = ctrl.updateAdventure(update);
        Assert.assertEquals(result.getTitle(), adv.getTitle());
        Assert.assertEquals(result.getAuthor(), adv.getAuthor());
        Assert.assertEquals(result.getTagLine(), adv.getTagLine());
        Assert.assertEquals(result.getDescription(), "updated");

        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertEquals(check, result, "Return value should match stored value");
    }

    @Test
    public void testGetChapter() {
        Adventure adv = ctrl.createAdventure("four", "four", "four", "four");
        Chapter chap = adv.getFirstChapter();

        Chapter chapterFound = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertNotNull(chapterFound);
        Assert.assertNull(chapterFound.getTeaser());
        Assert.assertNull(chapterFound.getHeading());
        Assert.assertNull(chapterFound.getProse());
        Assert.assertEquals(chapterFound.getStory(), adv);
    }

    @Test
    public void testUpdateChapter() {
        Adventure adv = ctrl.createAdventure("five", "five", "five", "five");
        Chapter chap = adv.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setTeaser("update");
        update.setHeading("update");
        update.setProse("update");

        Chapter result = ctrl.updateChapter(adv.getKey(), update);
        Assert.assertEquals(result.getTeaser(), "update");
        Assert.assertEquals(result.getHeading(), "update");
        Assert.assertEquals(result.getProse(), "update");

        Chapter check = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterTeaser() {
        Adventure adv = ctrl.createAdventure("five", "five", "five", "five");
        Chapter chap = adv.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setTeaser("update");

        Chapter result = ctrl.updateChapter(adv.getKey(), update);
        Assert.assertEquals(result.getTeaser(), "update");
        Assert.assertEquals(result.getHeading(), chap.getHeading());
        Assert.assertEquals(result.getProse(), chap.getProse());

        Chapter check = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterHeading() {
        Adventure adv = ctrl.createAdventure("five", "five", "five", "five");
        Chapter chap = adv.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setHeading("update");

        Chapter result = ctrl.updateChapter(adv.getKey(), update);
        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
        Assert.assertEquals(result.getHeading(), "update");
        Assert.assertEquals(result.getProse(), chap.getProse());

        Chapter check = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testUpdateChapterProse() {
        Adventure adv = ctrl.createAdventure("five", "five", "five", "five");
        Chapter chap = adv.getFirstChapter();

        Chapter update = new Chapter();
        update.setId(chap.getId());
        update.setProse("update");

        Chapter result = ctrl.updateChapter(adv.getKey(), update);
        Assert.assertEquals(result.getTeaser(), chap.getTeaser());
        Assert.assertEquals(result.getHeading(), chap.getHeading());
        Assert.assertEquals(result.getProse(), "update");

        Chapter check = ctrl.getChapter(adv.getKey(), chap.getId());
        Assert.assertEquals(check, result);
    }

    @Test
    public void testCreateNextChapter() {
        Adventure adv = ctrl.createAdventure("six", "six", "six", "six");
        Chapter first = adv.getFirstChapter();
        Chapter result = ctrl.addNextChapter(adv.getKey(), first.getId(), "Choose me!");

        first = ctrl.getAdventure(adv.getKey()).getFirstChapter();
        Chapter check = ctrl.getChapter(adv.getKey(), result.getId());
        Assert.assertNotNull(check);
        Assert.assertNotNull(result);
        Assert.assertEquals(check, result);
        Assert.assertEquals(first.getNextChapterOptions().size(), 1);
        Assert.assertEquals(first.getNextChapterOptions().get(0), result);
    }

    @Test
    public void testCreateChainOfNextChapters() {
        Adventure adv = ctrl.createAdventure("seven", "seven", "seven", "seven");
        String advKey = adv.getKey();
        Chapter first = adv.getFirstChapter();
        first.setTeaser("first level");
        Chapter second = ctrl.addNextChapter(advKey, first.getId(), "second level");
        Chapter third= ctrl.addNextChapter(advKey, second.getId(), "third level");
        Chapter fourth= ctrl.addNextChapter(advKey, third.getId(), "fourth level");

        Chapter secondCheck = ctrl.getChapter(advKey, second.getId());
        Chapter thirdCheck = ctrl.getChapter(advKey, third.getId());
        Chapter fourthCheck = ctrl.getChapter(advKey, fourth.getId());

        Assert.assertEquals(secondCheck, second);
        Assert.assertEquals(thirdCheck, third);
        Assert.assertEquals(fourthCheck, fourth);
    }

    @Test
    public void testDeleteStory() {
        Adventure adv = ctrl.createAdventure("eigth", "eigth", "eigth", "eigth");
        Adventure check = ctrl.getAdventure(adv.getKey());
        Assert.assertNotNull(check);

        ctrl.deleteAdventure(check.getKey());
        check = ctrl.getAdventure(adv.getKey());
        Assert.assertNull(check);
    }

    @Test
    public void testDeleteChapter() {

    }
}
