package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Date;

public class StoryPersistenceTest {

    private static final String TEST_PATH = "story-files-test/";

    private File getTestPathFile() {
        return new File(TEST_PATH);
    }

    @Test
    public void testInitializeWithDefaultPath() {
        StoryRepository repo = StoryRepository.getInstance();
        repo.setPersistence(new JSONFilePersistence());
        Story aStory = Story.createNew("Test Default Path", "Test", "Test", "Test");
        try {
            repo.addStory(aStory);
        } catch (Exception e) {
            Assert.fail("Bah", e);
        }
        Assert.assertNotNull(repo);
    }

    @Test
    public void testFailureToInitializeBombs() {
        StoryRepository repo = StoryRepository.getInstance();
        Story aStory = Story.createNew("Test Default Path", "Test", "Test", "Test");
        try {
            repo.addStory(aStory);
        } catch (Exception e) {
            return;  // perfect
        }
        Assert.fail("Should have died with first attempt to write to persistence.");
    }

    @Test
    public void testInitializeWithPath() throws Exception {
        StoryRepository repo = StoryRepository.getInstance();
        repo.setPersistence(new JSONFilePersistence(TEST_PATH));
        Assert.assertNotNull(repo);
        Assert.assertTrue(getTestPathFile().exists());
    }

    @Test
    public void testLoadRepository() throws Exception {
        StoryRepository repo = StoryRepository.getInstance();
        repo.setPersistence(new JSONFilePersistence(TEST_PATH));

        Assert.assertEquals(repo.getStories().size(), 2);
        Assert.assertNotNull(repo.getStory("11111111"));
        Assert.assertNotNull(repo.getStory("22222222"));
        Scene one = repo.getScene("10000001");
        Assert.assertNotNull(one);
        Assert.assertEquals(one.getNextSceneOptions().size(), 2);
        Assert.assertTrue(one.getNextSceneOptions().contains("10000002"));
        Assert.assertTrue(one.getNextSceneOptions().contains("10000003"));
        Assert.assertNotNull(repo.getScene("10000002"));
        Assert.assertNotNull(repo.getScene("10000003"));
    }

    @Test
    public void testStoreEntireRepository() throws Exception {
        StoryRepository repo = StoryRepository.getInstance();
        repo.setPersistence(new JSONFilePersistence("keep-me/"));

        Story oneStory = Story.createNew("One", "One", "One", "One");
        repo.addStory(oneStory);

        Scene firstScene = repo.getScene(oneStory.getFirstScene());
        firstScene.setHeading("One");
        firstScene.setTeaser("One");
        firstScene.setProse("One");
        repo.updateStory(oneStory);

        Assert.assertTrue(new File("keep-me/").listFiles().length > 0);
    }

}
