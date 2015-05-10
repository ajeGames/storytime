package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StoryTestUtil;
import com.ajegames.util.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.constraints.AssertTrue;
import java.io.File;
import java.util.Date;
import java.util.List;

public class JSONFilePersistenceTest {

    private static final String TEST_PATH = "story-files-test/";

    @Test
    public void testStoryPersistenceAPI() throws Exception {
        String pathName = "test-" + new RandomString(6).nextKey();  // play somewhere safe
        File path = new File(pathName);

        StoryPersistence storage = new JSONFilePersistence(pathName);
        Assert.assertTrue(path.exists(), "Should have found path to story files");
        Assert.assertTrue(path.isDirectory(), "Should have created directory for story files");

        // try saving
        StoryBundle story1 = StoryTestUtil.generateStoryBundle();
        storage.saveStory(story1);
        StoryBundle story2 = StoryTestUtil.generateStoryBundle();
        storage.saveStory(story2);
        Assert.assertEquals(path.listFiles().length, 2, "Expected to find story files");

        // try loading
        List<StoryBundle> stories = storage.loadStories();
        Assert.assertNotNull(stories, "Did not find stories");
        Assert.assertEquals(stories.size(), 2, "Wrong number of stories loaded");

        // try deleting
        storage.deleteStory(story1);
        storage.deleteStory(story2);
        Assert.assertEquals(path.listFiles().length, 0, "Story files should be gone");

        // clean up
        path.delete();
    }

    @Test
    public void testLoadStories() throws Exception {
        StoryPersistence storage = new JSONFilePersistence(TEST_PATH);
        List<StoryBundle> bundles = storage.loadStories();

        Assert.assertEquals(bundles.size(), 2);

        for (StoryBundle bundle : bundles) {
            String storyKey = bundle.getStory().getKey();
            Assert.assertTrue(storyKey.equals("11111111") || storyKey.equals("22222222"));
            if (storyKey.equals("11111111")) {
                Assert.assertEquals(bundle.getScenes().size(), 3);
            } else {
                Assert.assertEquals(bundle.getScenes().size(), 1);
            }

        }

    }
}
