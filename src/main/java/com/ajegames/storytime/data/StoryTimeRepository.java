package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.SceneSummary;
import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;
import java.util.*;

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

    public Story addStory(Story story) throws Exception {
        // if given story has key and item already exists, throw something; use update instead
        if (story.getKey() != null) {
            throw new Exception("The given Story specifies a key that is already in use. Either clear the key or " +
                    "use update method.");
        }
        // otherwise, pick a new key
        story.setKey(keyGenerator.nextString());
        stories.put(story.getKey(), story);

        // make sure first scene is indexed and has a key
        if (story.getFirstScene() != null && story.getFirstScene().getKey() == null) {
            addScene(story.getFirstScene());
        }

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
        story.setTitle(update.getTitle());
        story.setAuthor(update.getAuthor());
        story.setTagLine(update.getTagLine());
        story.setDescription(update.getDescription());
    }

    public void removeStory(String key) {
        Story story = getStory(key);
        if (story == null) {
            return;
            // TODO decide whether to indicate not found or quietly ignore
        }
        if (story.getFirstScene() != null) {
            String firstSceneKey = story.getFirstScene().getKey();
            removeScenesInChain(firstSceneKey);
            scenes.remove(firstSceneKey);
        }
        stories.remove(key);
    }

    public void removeScenesInChain(String key) {
        Scene aScene = scenes.get(key);
        if (aScene != null) {
            List<SceneSummary> options = aScene.getNextSceneOptions();
            if (options != null) {
                for (SceneSummary summary : options) {
                    removeScenesInChain(summary.getKey());
                }
            } else {
                removeScene(key);
            }
        }
    }

    public List<Story> getStories() {
        List<Story> result = new ArrayList<Story>();
        result.addAll(stories.values());
        return result;
    }

    public Scene addScene(Scene scene) {
        scene.setKey(keyGenerator.nextString());
        scenes.put(scene.getKey(), scene);
        return scene;
    }

    public SceneSummary addScene(SceneSummary summary) {
        Scene in = Scene.create(summary);
        addScene(in);
        summary.setKey(in.getKey());
        return summary;
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
