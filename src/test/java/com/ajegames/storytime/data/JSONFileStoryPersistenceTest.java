package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.AdventureTestUtil;
import com.ajegames.util.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JSONFileStoryPersistenceTest {

    private static final String TEST_PATH = "story-files-test/";

    @Test
    public void testStoryPersistenceAPI() throws Exception {
        String pathName = "test-" + new RandomString(6).nextKey();  // play somewhere safe
        File path = new File(pathName);

        AdventurePersistence storage = new JSONFileAdventurePersistence(pathName);
        Assert.assertTrue(path.exists(), "Should have found path to story files");
        Assert.assertTrue(path.isDirectory(), "Should have created directory for story files");

        // try saving
        Story adv1 = AdventureTestUtil.generateAdventure();
        storage.saveAdventure(adv1);
        Story adv2 = AdventureTestUtil.generateAdventure();
        storage.saveAdventure(adv2);
        Assert.assertEquals(path.listFiles().length, 2, "Expected to find story files");

        // try loading
        List<Story> stories = storage.loadAdventures();
        Assert.assertNotNull(stories, "Did not find stories");
        Assert.assertEquals(stories.size(), 2, "Wrong number of stories loaded");

        // try deleting
        storage.deleteAdventure(adv1);
        storage.deleteAdventure(adv2);
        Assert.assertEquals(path.listFiles().length, 0, "Story files should be gone");

        // clean up
        path.delete();
    }

    @Test
    public void testLoadStories() throws Exception {
        AdventurePersistence storage = new JSONFileAdventurePersistence(TEST_PATH);
        List<Story> stories = storage.loadAdventures();
        Assert.assertEquals(stories.size(), 2);

        for (Story story : stories) {
            String adventureKey = story.getKey();
            Assert.assertTrue(adventureKey.equals("mvghheo8") || adventureKey.equals("ni7l0szw"));
        }
    }
}
