package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StoryTestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests the capabilities of the unit for storing stories and scenes.
 */
public class StoryBundleTest {

    @Test
    public void testPuttingBundleTogether() {
        // construct a story
        StoryBundle bundle = new StoryBundle();
        Story myStory = StoryTestUtil.generateTestStoryWithKey();
        bundle.setStory(myStory);

        // create some scenes that are connected to the story
        List<Scene> scenes = new ArrayList<Scene>();
        Scene firstScene = StoryTestUtil.generateTestSceneWithGivenKey(myStory.getFirstScene());
        scenes.add(firstScene);

        for (int i=0; i < 3; i++) {
            Scene myScene = StoryTestUtil.generateTestSceneWithKey();
            scenes.add(myScene);
            firstScene.addNextSceneOption(myScene.getKey());
        }
        bundle.setScenes(scenes);

        Assert.assertNotNull(bundle.getStory());
        Assert.assertEquals(bundle.getStory(), myStory);
        Assert.assertNotNull(bundle.getScenes());
        Assert.assertEquals(bundle.getScenes().size(), 4);
    }
}
