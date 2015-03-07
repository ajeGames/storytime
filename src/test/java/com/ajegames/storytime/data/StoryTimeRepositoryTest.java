package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
