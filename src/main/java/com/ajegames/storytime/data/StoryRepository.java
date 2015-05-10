package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
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

    private static StoryRepository instance;
    private static Logger LOG = LoggerFactory.getLogger(StoryRepository.class);

    private StoryPersistence storage;
    private RandomString keyGenerator;
    private Map<String, Story> stories;
    private Map<String, Scene> scenes;
    private Map<String, Set<String>> storySceneMap;

    private StoryRepository() {
        storage = new DefaultPersistence();
        stories = new HashMap<String, Story>();
        scenes = new HashMap<String, Scene>();
        storySceneMap = new HashMap<String, Set<String>>();
        keyGenerator = new RandomString(8);
    }

    /**
     * Call first before attempting to getInstance().
     *
     * @param persistenceImpl
     * @return
     */
    public void setPersistence(StoryPersistence persistenceImpl) {
        if (storage == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        storage = persistenceImpl;
        load(storage.loadStories());
    }

    public void load(List<StoryBundle> stories) {
        for (StoryBundle graph : stories) {

        }
    }

    public static StoryRepository getInstance() {
        if (instance == null) {
            instance = new StoryRepository();
        }
        return instance;
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
            throw new IllegalArgumentException("Story must already have key.");
        }
        if (stories.containsKey(key)) {
            LOG.warn("Key for story being added already in use.  Replacing story.");
        }
        stories.put(key, storyToLoad);
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
            String tempKey;
            do {
                tempKey = keyGenerator.nextString();
            } while (stories.containsKey(tempKey));
            story.setKey(tempKey);
        }
        loadStory(story);

        // if scene is not set, create a new scene and set firstScene key on story
        // if scene is set but not found in repo, treat as new.
        if (story.getFirstScene() == null || !scenes.containsKey(story.getFirstScene())) {

            // TODO perhaps initial scene should be empty -- for now, make the fields visible

            Scene firstScene = Scene.createNew("Get ready for adventure!", "Opening scene",
                    "This is the opening scene.  Grab your reader's attention.");
            firstScene = addScene(story.getKey(), firstScene);
            story.setFirstScene(firstScene.getKey());
        }

        storage.saveStory(new StoryBundle());
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

    public void loadScene(String storyKey, Scene sceneToLoad) {
        if (storyKey == null) {
            throw new IllegalArgumentException("Must indicate valid story key.");
        }
        String sceneKey = sceneToLoad.getKey();
        if (sceneKey == null) {
            throw new IllegalArgumentException("Scene must already have key.");
        }
        if (stories.containsKey(sceneKey)) {
            LOG.warn("Key for story being added already in use.  Replacing story.");
        }
        scenes.put(sceneKey, sceneToLoad);
        addToStorySceneMap(storyKey, sceneKey);
    }

    private void addToStorySceneMap(String storyKey, String sceneKey) {
        Set scenes = storySceneMap.get(storyKey);
        if (scenes == null) {
            scenes = new HashSet<String>();
            storySceneMap.put(storyKey, scenes);
        }
        scenes.add(sceneKey);
    }

    public Scene addScene(String storyKey, Scene scene) {
        if (scene.getKey() == null) {
            String tempKey;
            do {
                tempKey = keyGenerator.nextString();
            } while (scenes.containsKey(tempKey));
            scene.setKey(tempKey);
        }
        loadScene(storyKey, scene);
        return scene;
    }

    public Scene getScene(String key) {
        return scenes.get(key);
    }

    public Set<Scene> getScenesForStory(String storyKey) {
        Set<Scene> fullScenes = new HashSet<Scene>();
        Set<String> sceneKeys = storySceneMap.get(storyKey);
        if (sceneKeys != null) {
            for (String key : sceneKeys) {
                fullScenes.add(scenes.get(key));
            }
        }
        return fullScenes;
    }

    public void updateScene(Scene update) {
        Scene scene = scenes.get(update.getKey());
        if (scene == null) {
            throw new NullPointerException("Scene not found: " + update.getKey());
        }
        scenes.put(update.getKey(), update);
    }

    public void removeScene(String key) {
        // FIXME
//        storage.deleteStory(getStory(key));
        scenes.remove(key);
    }
}
