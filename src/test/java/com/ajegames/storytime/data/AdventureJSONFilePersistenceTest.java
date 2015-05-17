package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;
import com.ajegames.storytime.model.AdventureTestUtil;
import com.ajegames.util.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class AdventureJSONFilePersistenceTest {

    private static final String TEST_PATH = "story-files-test/";

    @Test
    public void testStoryPersistenceAPI() throws Exception {
        String pathName = "test-" + new RandomString(6).nextKey();  // play somewhere safe
        File path = new File(pathName);

        AdventurePersistence storage = new AdventureJSONFilePersistence(pathName);
        Assert.assertTrue(path.exists(), "Should have found path to story files");
        Assert.assertTrue(path.isDirectory(), "Should have created directory for story files");

        // try saving
        Adventure adv1 = AdventureTestUtil.generateAdventureWithoutKey();
        adv1.setKey("test0001");
        storage.saveAdventure(adv1);
        Adventure adv2 = AdventureTestUtil.generateAdventureWithoutKey();
        adv2.setKey("test0001");
        storage.saveAdventure(adv2);
        Assert.assertEquals(path.listFiles().length, 2, "Expected to find story files");

        // try loading
        List<Adventure> adventures = storage.loadAdventures();
        Assert.assertNotNull(adventures, "Did not find stories");
        Assert.assertEquals(adventures.size(), 2, "Wrong number of stories loaded");

        // try deleting
        storage.deleteAdventure(adv1);
        storage.deleteAdventure(adv2);
        Assert.assertEquals(path.listFiles().length, 0, "Story files should be gone");

        // clean up
        path.delete();
    }

    @Test
    public void testLoadStories() throws Exception {
        AdventurePersistence storage = new AdventureJSONFilePersistence(TEST_PATH);
        List<Adventure> adventures = storage.loadAdventures();
        Assert.assertEquals(adventures.size(), 2);

        for (Adventure adventure : adventures) {
            String adventureKey = adventure.getKey();
            Assert.assertTrue(adventureKey.equals("11111111") || adventureKey.equals("22222222"));
//            if (adventureKey.equals("11111111")) {
//                Assert.assertEquals(adventure.getChapters().size(), 3);
//            } else {
//                Assert.assertEquals(adventure.getScenes().size(), 1);
//            }
        }
    }
}
