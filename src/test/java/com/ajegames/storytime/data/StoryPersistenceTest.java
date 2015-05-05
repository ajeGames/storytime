package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Date;

public class StoryPersistenceTest {

    private static final String TEST_PATH = "story-files-test/";

    private File getTestPath() {
        return new File(TEST_PATH);
    }

    @Test
    public void testInitializeWithDefaultPath() {
        StoryPersistence.reset();

        StoryPersistence instance = StoryPersistence.getInstance();
        Assert.assertNotNull(instance);
        StoryRepository repo = StoryPersistence.getStoryRepository();
        Assert.assertNotNull(repo);
    }

    @Test
    public void testInitializeWithPath() throws Exception {
        StoryPersistence.reset();

        StoryPersistence.initialize(TEST_PATH);
        StoryPersistence instance = StoryPersistence.getInstance();
        Assert.assertNotNull(instance);
        StoryRepository repo = StoryPersistence.getStoryRepository();
        Assert.assertNotNull(repo);
        Assert.assertTrue(getTestPath().exists());
    }

    @Test
    public void testInitializeWithNonexistentPath() throws Exception {
        StoryPersistence.reset();
        String pathName = "randomTestPath-" + new Date().toString();

        StoryPersistence.initialize(pathName);
        StoryPersistence instance = StoryPersistence.getInstance();
        Assert.assertNotNull(instance);

        File path = new File(pathName);
        Assert.assertTrue(path.exists());
        Assert.assertTrue(path.delete(), "Unable to remove directory");
    }

    @Test
    public void testLoadRepository() throws Exception {
        StoryPersistence.reset();

        StoryPersistence.initialize(TEST_PATH);
        StoryRepository repo = StoryPersistence.getStoryRepository();
        Assert.assertNotNull(repo);

        Assert.assertEquals(repo.getStories().size(), 1);
        Assert.assertNotNull(repo.getStory("11111111"));
        Scene one = repo.getScene("10000001");
        Assert.assertNotNull(one);
        Assert.assertEquals(one.getNextSceneOptions().size(), 2);
        Assert.assertTrue(one.getNextSceneOptions().contains("10000002"));
        Assert.assertTrue(one.getNextSceneOptions().contains("10000003"));
        Assert.assertNotNull(repo.getScene("10000002"));
        Assert.assertNotNull(repo.getScene("10000003"));
    }

}
