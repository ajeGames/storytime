package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.SceneSummary;
import com.ajegames.storytime.model.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Puts the repository through its paces.
 */
public class StoryRepositoryTest {

    @Test
    public void testAddStorySetsKey() {
        try {
            Story myStory = new Story();
            StoryRepository instance = StoryPersistence.getStoryRepository();
            Story result = instance.addStory(myStory);
            Assert.assertNotNull(result.getKey());
        } catch (Exception e) {
            Assert.fail("Fail", e);
        }
    }

    @Test
    public void testAddingStoryAlsoSetsFirstSceneKey() {
        try {
            StoryRepository instance = StoryPersistence.getStoryRepository();
            Story toAdd = new Story();
            toAdd.setTitle("A Cautionary Tale");
            Story out = instance.addStory(toAdd);
            Assert.fail("FIXME");
        } catch (Exception e) {
            Assert.fail("Unexpected", e);
        }
    }

    @Test
    public void testAddWithExistingKeyThrowsException() {
        try {
            Story myStory = new Story();
            StoryRepository instance = StoryPersistence.getStoryRepository();
            Story result = instance.addStory(myStory);
            try {
                instance.addStory(result);
            } catch (Exception e) {
                // expected
            }
        } catch (Exception e) {
            Assert.fail("Unexpected", e);
        }
    }

    @Test
    public void testGetStories() {
        try {
            StoryRepository instance = StoryPersistence.getStoryRepository();
            Story toAdd = new Story();
            toAdd.setTitle("blah");
            instance.addStory(toAdd);
            toAdd = new Story();
            toAdd.setTitle("biddy");
            instance.addStory(toAdd);
            toAdd = new Story();
            toAdd.setTitle("bah");
            instance.addStory(toAdd);
            List<Story> out = instance.getStories();
            Assert.assertFalse(out.isEmpty());
        } catch (Exception e) {
            Assert.fail("Fail", e);
        }
    }

    @Test
    public void testDeleteStoryWithScenes() {
        StoryRepository repo = StoryPersistence.getStoryRepository();
        Scene first = repo.addScene(Scene.create("A teaser", "A heading", "A prose prose prose"));
        Scene second = repo.addScene(Scene.create("B teaser", "B heading", "B prose prose prose"));
        Scene third = repo.addScene(Scene.create("C teaser", "C heading", "C prose prose prose"));
        first.addNextSceneOption(second.getKey());
        first.addNextSceneOption(third.getKey());
        try {
            Story myStory = repo.addStory(Story.create("Some Story", "Somebody", "Something catchy", "Something compelling",
                    first.getKey()));
            Assert.assertNotNull(repo.getScene(first.getKey()));
            Assert.assertNotNull(repo.getScene(second.getKey()));
            Assert.assertNotNull(repo.getScene(third.getKey()));
            repo.removeStory(myStory.getKey());

            String key = first.getKey();
            Scene scene = repo.getScene(key);
            Assert.assertNull(scene);

            Assert.assertNull(repo.getScene(first.getKey()));
            Assert.assertNull(repo.getScene(second.getKey()));
            Assert.assertNull(repo.getScene(third.getKey()));
        } catch (Exception e) {
            Assert.fail("Could not add story", e);
        }
    }
}
