package com.ajegames.storytime.data;

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
    public void testAddWithExistingKeyThrowsException() {
        try {
            Story myStory = new Story();
            StoryTimeRepository instance = StoryTimeRepository.getInstance();
            Story result = instance.addStory(myStory);
            String key1 = result.getKey();
            try {
                Story result2 = instance.addStory(result);
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
}
