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
public class StoryTimeRepositoryTest {

    @Test
    public void testAddStorySetsKey() {
        try {
            Story myStory = new Story();
            StoryTimeRepository instance = StoryTimeRepository.getInstance();
            Story result = instance.addStory(myStory);
            Assert.assertNotNull(result.getKey());
        } catch (Exception e) {
            Assert.fail("Fail", e);
        }
    }

    @Test
    public void testAddingStoryAlsoSetsFirstSceneKey() {
        try {
            StoryTimeRepository instance = StoryTimeRepository.getInstance();
            Story toAdd = new Story();
            toAdd.setTitle("A Cautionary Tale");
            toAdd.setFirstScene(SceneSummary.create("Everything comes down to the choice you must make."));
            Story out = instance.addStory(toAdd);
            Assert.assertNotNull(out.getFirstScene().getKey());
        } catch (Exception e) {
            Assert.fail("Unexpected", e);
        }
    }

    @Test
    public void testAddWithExistingKeyThrowsException() {
        try {
            Story myStory = new Story();
            StoryTimeRepository instance = StoryTimeRepository.getInstance();
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
            StoryTimeRepository instance = StoryTimeRepository.getInstance();
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
        StoryTimeRepository instance = StoryTimeRepository.getInstance();
        Story myStory = new Story();
        Scene first = Scene.create("top level", "top level", "top level");
        SceneSummary anotherOption = SceneSummary.create("second A");
        first.addNextSceneOption(anotherOption);
        first.addNextSceneOption(SceneSummary.create("second B"));
        first.addNextSceneOption(SceneSummary.create("second C"));
    }
}
