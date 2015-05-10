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
    private Map<String, StoryBundle> storyBundles;
    private Map<String, Set<String>> storySceneMap;

    private StoryRepository() {
        storage = new DefaultPersistence();
        storyBundles = new HashMap<String, StoryBundle>();
        storySceneMap = new HashMap<String, Set<String>>();
        keyGenerator = new RandomString(8);
    }

    /**
     * Returns singleton instance of story repository.  Be sure persistence mechanism is set before attempting to
     * use singleton.
     *
     * @return StoryRepository singleton instance of repo
     */
    public static StoryRepository getInstance() {
        if (instance == null) {
            instance = new StoryRepository();
        }
        return instance;
    }

    /**
     * Establishes approach to persistence and loads repository with whatever stories are available.  Call before
     * using the repository; otherwise things will go badly.
     *
     * @param persistenceImpl
     */
    public void setPersistence(StoryPersistence persistenceImpl) {
        if (persistenceImpl == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        storage = persistenceImpl;
        loadRepository();
    }

    private void loadRepository() {
        List<StoryBundle> bundles = storage.loadStories();
        for (StoryBundle bundle : bundles) {
            loadStoryBundle(bundle);
        }
    }

    /**
     * Loads story as-is into repository.  Expected to already have key assigned; otherwise will not load.
     * If another story is already loaded with the same key, the new story will take its place.
     *
     * @param bundleToLoad
     */
    public void loadStoryBundle(StoryBundle bundleToLoad) {
        String key = bundleToLoad.getStory().getKey();
        if (key == null) {
            throw new IllegalArgumentException("Story must already have key.");
        }
        if (storyBundles.containsKey(key)) {
            LOG.warn("Given story key already in use.  Replacing.");
        }
        storyBundles.put(key, bundleToLoad);

        for (Scene sceneInBundle : bundleToLoad.getScenes()) {
            addToStorySceneMap(key, sceneInBundle.getKey());
        }
    }

    /**
     * Adds a story to repository.  New stories without a key can be added.  The story that is returned will
     * have a new unique key and empty first scene assigned.
     *
     * @param story
     * @return
     * @throws Exception
     */
    public Story addStory(Story story) throws Exception {
        if (story.getKey() != null) {
            throw new IllegalArgumentException("Can only add new stories (i.e., without a key) to repository");
        }
        String tempKey;
        do {
            tempKey = keyGenerator.nextKey();
        } while (storyBundles.containsKey(tempKey));
        story.setKey(tempKey);

        // new stories need a first scene
        Scene firstScene = addScene(tempKey, Scene.createNew("First scene", "Scene One", "Open your story"));
        story.setFirstScene(firstScene.getKey());

        StoryBundle bundle = new StoryBundle();
        bundle.setStory(story);
        bundle.addScene(firstScene);

        storage.saveStory(bundle);
        return story;
    }

    public Story getStory(String key) {
        return storyBundles.get(key).getStory();
    }

    public void updateStory(Story update) {
        Story story = storyBundles.get(update.getKey()).getStory();
        if (story == null) {
            throw new NullPointerException("Story not found: " + update.getKey());
        }
        story.setTitle(update.getTitle());
        story.setAuthor(update.getAuthor());
        story.setTagLine(update.getTagLine());
        story.setDescription(update.getDescription());
    }

    public void removeStory(String key) {
        StoryBundle bundle = storyBundles.get(key);
        if (bundle == null) {
            LOG.warn("Story to be removed was not found; doing nothing.");
            return;
        }
        storyBundles.remove(key);
        storySceneMap.remove(key);
        storage.deleteStory(bundle);
    }

    public List<Story> getStories() {
        List<Story> out = new ArrayList<Story>();
        for (StoryBundle bundle : storyBundles.values()) {
            out.add(bundle.getStory());
        }
        return out;
    }

    // TODO clean this up
    private void addToStorySceneMap(String storyKey, String sceneKey) {
        Set<String> sceneKeys = storySceneMap.get(storyKey);
        if (sceneKeys == null) {
            sceneKeys = new HashSet<String>();
            storySceneMap.put(storyKey, sceneKeys);
        }
        sceneKeys.add(sceneKey);
    }

    // TODO clean this up
    public Scene addScene(String storyKey, Scene scene) {
        Set<String> sceneKeys = storySceneMap.get(storyKey);
        if (scene.getKey() == null) {
            String tempKey;
            do {
                tempKey = keyGenerator.nextKey();
            } while (sceneKeys.contains(tempKey));
            scene.setKey(tempKey);
        }
        addToStorySceneMap(storyKey, scene.getKey());
        return scene;
    }
//
//    public Scene getScene(String key) {
//        return scenes.get(key);
//    }
//
//    public Set<Scene> getScenesForStory(String storyKey) {
//        Set<Scene> fullScenes = new HashSet<Scene>();
//        Set<String> sceneKeys = storySceneMap.get(storyKey);
//        if (sceneKeys != null) {
//            for (String key : sceneKeys) {
//                fullScenes.add(scenes.get(key));
//            }
//        }
//        return fullScenes;
//    }
//
//    public void updateScene(Scene update) {
//        Scene scene = scenes.get(update.getKey());
//        if (scene == null) {
//            throw new NullPointerException("Scene not found: " + update.getKey());
//        }
//        scenes.put(update.getKey(), update);
//    }
//
//    public void removeScene(String key) {
//        // FIXME
////        storage.deleteStory(getStory(key));
//        scenes.remove(key);
//    }
}
