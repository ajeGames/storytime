package com.ajegames.storytime.model;

import com.ajegames.storytime.data.AdventureRepository;
import com.ajegames.storytime.data.StoryPersistence;
import com.ajegames.storytime.data.StoryRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by dmount on 5/16/15.
 */
public class StoryControllerTest {

    private StoryController ctrl;

    @BeforeClass
    public void setup() {
        ctrl = new StoryController();
    }

    @Test
    public void createStory() {
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
    public void getStory() {
        Adventure adv1 = ctrl.createAdventure("one", "one", "one", "one");
        Adventure adv2 = ctrl.createAdventure("one", "one", "one", "one");

        Assert.assertNotNull(ctrl.getAdventure(adv1.getKey()));
        Assert.assertNotNull(ctrl.getAdventure(adv2.getKey()));
    }
}
