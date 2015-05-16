package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StoryTestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Puts the repository through its paces.
 */
public class StoryRepositoryTest {

    private StoryRepository repo;

    @BeforeClass
    public void setup() throws Exception {
        repo = StoryRepository.getInstance();
        repo.setPersistence(new JSONFilePersistence("test-repo"));
    }

    @AfterClass
    public void tearDown() throws Exception {
        // TODO implement something that allows test to clean up environment when tests are done
    }

    @Test
    public void testFailureToInitializePersistenceBombs() {
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
    public void testAddStoryWithoutKeySetsKey() throws Exception {
        Story myStory = Story.createNew("Test Story", "A. Writer", "Read me", "This is a test story");
        Story out = repo.addStory(myStory);
        Assert.assertNotNull(out);
        Assert.assertNotNull(out.getKey());
    }

    @Test
    public void testAddStoryWithKeyPreservesKey() throws Exception {
        Story myStory = Story.createExisting("12345678", "Test Story", "A. Writer", "Read me", "This is a test story",
                "scn0001");
        Story out = repo.addStory(myStory);
        Assert.assertNotNull(out);
        Assert.assertEquals(out.getKey(), "12345678");
    }

    @Test
    public void testAddedStoryFoundInRepo() throws Exception {
        Story myStory = Story.createNew("Test Story", "A. Writer", "Read me", "This is a test story");
        Story out = repo.addStory(myStory);
        Story fromRepo = repo.getStory(out.getKey());
        Assert.assertEquals(fromRepo, out);
    }

    @Test
    public void testAddNewStoryCreatesFirstScene() throws Exception {
        Story myStory = Story.createNew("Jungle Cruise", "Indiana Jones", "So you don't like snakes?",
                "Travel the Amazon with a famous archaeologist.");
        Story result = repo.addStory(myStory);
        String firstSceneKey = result.getFirstScene();
        Assert.assertNotNull(firstSceneKey);
        Assert.assertNotNull(repo.getScene(firstSceneKey));
    }

    @Test
    public void testAddNextScene() throws Exception {
        Story myStory = StoryTestUtil.generateTestStoryWithoutKey();
        myStory = repo.addStory(myStory);
        Scene firstScene = repo.getScene(myStory.getFirstScene());
        Scene nextScene = StoryTestUtil.generateTestSceneWithoutKey();
        repo.addNextScene(firstScene.getKey(), nextScene);

        Scene check = repo.getScene(nextScene.getKey());
        Assert.assertNotNull(check);
        Assert.assertNotNull(repo.getScene(firstScene.getKey()).getNextSceneOptions().contains(check.getKey()));
    }

    // TODO test that story update, new scene, scene update, scene delete causes story to be saved

}
