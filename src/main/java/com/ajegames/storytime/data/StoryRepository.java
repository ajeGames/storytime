package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.SceneSummary;
import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * <code>StoryRepositoryInMemoryImpl</code> manages storage and retrieval of stories.  See StoryPersistence to
 * access singleton instance of this class.
 */
public class StoryRepository {

    private static Logger LOG = LoggerFactory.getLogger(StoryRepository.class);

    private Map<String, Story> stories;
    private Map<String, Scene> scenes;
    private RandomString keyGenerator;

    public StoryRepository() {
        stories = new HashMap<String, Story>();
        scenes = new HashMap<String, Scene>();
        keyGenerator = new RandomString(8);
    }

    /**
     * Loads story as-is into repository.  Expected to already have key assigned; otherwise will not load.
     * If another story is already loaded with the same key, the new story will take its place.
     *
     * @param storyToLoad
     */
    public void loadStory(Story storyToLoad) {
        String key = storyToLoad.getKey();
        if (key == null) {
            LOG.warn("Story not loaded; must already have key.");
            return;
        }
        if (stories.containsKey(key)) {
            LOG.warn("Key for story being added already in use.  Replacing story.");
        }
        stories.put(storyToLoad.getKey(), storyToLoad);
    }

    /**
     * Adds a story to repository.  New stories without a key can be added.  Okay to add stories with key
     * defined.  If there is already a story with the same key, it will be replaced by the new one.
     * The story that is returned will have a unique key assigned.
     *
     * @param story
     * @return
     * @throws Exception
     */
    public Story addStory(Story story) throws Exception {
        // without key ==> assign unique key
        if (story.getKey() == null) {
            String tempKey = keyGenerator.nextString();
            while (stories.containsKey(tempKey)) {
                tempKey = keyGenerator.nextString();
            }
            story.setKey(tempKey);
        }
        loadStory(story);
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
            LOG.warn("Story to be removed was not found.");
            return;
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
