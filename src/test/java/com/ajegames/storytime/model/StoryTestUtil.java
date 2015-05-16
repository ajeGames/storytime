package com.ajegames.storytime.model;

import com.ajegames.storytime.data.StoryBundle;
import com.ajegames.util.RandomString;

import java.util.ArrayList;
import java.util.List;

/**
 * The start of some builders for generating test data.
 */
public class StoryTestUtil {

    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Story generateTestStoryWithoutKey() {
        return Story.createNew(fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey());
    }

    public static Story generateTestStoryWithKey() {
        return generateTestStoryWithGivenKey(keyGenerator.nextKey());
    }

    public static Story generateTestStoryWithGivenKey(String key) {
        return Story.createExisting(key, fillGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey(), fillGenerator.nextKey(), keyGenerator.nextKey());
    }

    public static Scene generateTestSceneWithoutKey() {
        return Scene.createNew(fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey());
    }

    public static Scene generateTestSceneWithKey() {
        return generateTestSceneWithGivenKey(keyGenerator.nextKey());
    }

    public static Scene generateTestSceneWithGivenKey(String key) {
        return Scene.createExisting(key, fillGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey());
    }

    public static StoryBundle generateStoryBundle() {
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
        return bundle;
    }
}
