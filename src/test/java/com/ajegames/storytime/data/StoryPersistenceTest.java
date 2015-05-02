package com.ajegames.storytime.data;

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

    @BeforeClass
    public void setup() {
        File testPath = getTestPath();
        if (!testPath.exists()) {
            Assert.assertTrue(testPath.mkdir());
        }
    }

    @AfterClass
    public void cleanup() {
        Assert.assertTrue(getTestPath().delete());
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
}
