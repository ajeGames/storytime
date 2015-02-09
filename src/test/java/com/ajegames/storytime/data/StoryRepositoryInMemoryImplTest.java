package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests a simple implementation of StoryRepository that is not backed by a database.
 */
public class StoryRepositoryInMemoryImplTest {

    @Test
    public void testRegisterStoryAndGetStory() {
        Story in = Story.createStory("Mr. Happy", "Roger Hargreaves", "About a little guy with a big smile.");
        StoryRepository repo = StoryRepositoryInMemoryImpl.singleton;
        String key = repo.registerStory(in);

        Assert.assertEquals(repo.getStory(key), in);
    }
}
