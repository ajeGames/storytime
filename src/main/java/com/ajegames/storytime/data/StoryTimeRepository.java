package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <code>StoryRepositoryInMemoryImpl</code> manages storage and retrieval of stories.
 */
public class StoryTimeRepository {

    private static final StoryTimeRepository repo = new StoryTimeRepository();

    private Map<String, Story> stories;
    private Map<String, Scene> scenes;
    private RandomString keyGenerator;

    private StoryTimeRepository() {
        stories = new HashMap<String, Story>();
        scenes = new HashMap<String, Scene>();
        keyGenerator = new RandomString(8);
    }

    public static StoryTimeRepository getInstance() {
        return repo;
    }

    public Story addStory(Story story) {
        story.setKey(keyGenerator.nextString());
        stories.put(story.getKey(), story);
        return story;
    }

    public Story getStory(String key) {
        return stories.get(key);
    }

    public void updateStory(Story update) {
        Story story = stories.get(update.getKey());
        if (story == null) {
            throw new NullPointerException("Story not found: " + update.getKey());
        }
        stories.put(update.getKey(), update);
    }

    public void removeStory(String key) {
        stories.remove(key);
    }

    public List<Story> getStories() {
        return (List<Story>) stories.values();
    }

    public Scene addScene(Scene scene) {
        scene.setKey(keyGenerator.nextString());
        scenes.put(scene.getKey(), scene);
        return scene;
    }

    public Scene getScene(String key) {
        return scenes.get(key);
    }

    public void updateScene(Scene update) {
        Scene scene = scenes.get(update.getKey());
        if (scene == null) {
            throw new NullPointerException("Scene not found: " + update.getKey());
        }
        scenes.put(update.getKey(), update);
    }

    public void removeScene(String key) {
        scenes.remove(key);
    }
}
