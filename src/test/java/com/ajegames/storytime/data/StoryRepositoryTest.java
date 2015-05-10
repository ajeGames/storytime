package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
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
    void testLoadStoryWithKeyWorks() {
        Story myStory = Story.createExisting("abcd1234", "Test Story", "A. Writer", "Read me", "This is a test story",
                "scn0001");
        repo.loadStory(myStory);

    }

    @Test
    public void testLoadStoryWithoutKeyFails() {
        Story myStory = Story.createNew("Test Story", "A. Writer", "Read me", "This is a test story");
        try {
            repo.loadStory(myStory);
        } catch (Exception e) {
            // supposed to throw something
            return;
        }
        Assert.fail("Excepted to have a problem loading new story (i.e., without a key)");
    }

    @Test
    public void testLoadStoryWithNonUniqueKeyReplacesStoryInRepo() throws Exception {
        Story first = Story.createNew("A story", "An author", "A tag line", "A description");
        first = repo.addStory(first);
        Story result = repo.getStory(first.getKey());
        Assert.assertEquals(result, first);

        Story second = Story.createExisting(first.getKey(), "New Story", "New Author", "Blah", "Blah",
                first.getFirstScene());
        repo.loadStory(second);
        result = repo.getStory(first.getKey());
        Assert.assertEquals(result, second);

        // TODO think through what happens to abandoned scenes -- maybe should not allow loading of stories with non-unique keys
    }

    @Test
    public void testLoadedStoryFoundInRepo() throws Exception {
        Story myStory = Story.createExisting("qwerty123", "Test Story", "A. Writer", "Read me", "This is a test story",
                "scn0001");
        repo.loadStory(myStory);
        Story fromRepo = repo.getStory(myStory.getKey());
        Assert.assertEquals(fromRepo, myStory);
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

}
