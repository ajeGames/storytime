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

    private RandomString keyGenerator;
    private Map<String, Story> stories;
    private Map<String, Scene> scenes;
    private Map<String, String> storySceneMap;

    public StoryRepository() {
        stories = new HashMap<String, Story>();
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
            throw new RuntimeException("Story not loaded; must already have key.");
        }
        if (stories.containsKey(key)) {
            LOG.warn("Key for story being added already in use.  Replacing story.");
        }
        StoryGraph graph = new StoryGraph();
        stories.put(storyToLoad.getKey(), storyToLoad);
    }

    /**
     * Adds a story to repository.  New stories without a key can be added.  Okay to add stories with key
     * defined.  If there is already a story with the same key, it will be replaced by the new one.
     * The story that is returned will have a unique key assigned.
     *
     * Also creates first scene for new stories.
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

        // TODO need to create firstScene

        if (story.getFirstScene() != null) {
            if (scenes.containsKey(story.getFirstScene())) {
            }
        }

        // if scene is not set, create a new scene and set firstScene key on story
        // if scene is set but not found in repo, treat as new.
        if (story.getFirstScene() == null || !scenes.containsKey(story.getFirstScene())) {

            // TODO perhaps initial scene should be empty -- for now, make the fields visible

            Scene firstScene = Scene.createNew("Get ready for adventure!", "Opening scene",
                    "This is the opening scene.  Grab your reader's attention.");
            firstScene = addScene(firstScene);
            story.setFirstScene(firstScene.getKey());
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
            LOG.warn("Story to be removed was not found.");
            return;
        }
        if (story.getFirstScene() != null) {
            String firstSceneKey = story.getFirstScene();
            removeScenesInChain(firstSceneKey);
            scenes.remove(firstSceneKey);
        }
        stories.remove(key);
    }

    public void removeScenesInChain(String key) {
        Scene aScene = scenes.get(key);
        if (aScene != null) {
            List<String> options = aScene.getNextSceneOptions();
            if (options != null) {
                for (String optionKey : options) {
                    removeScenesInChain(optionKey);
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
