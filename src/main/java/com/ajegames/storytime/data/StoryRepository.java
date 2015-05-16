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
    private Map<String, String> sceneStoryMap;

    private StoryRepository() {
        storage = new DefaultPersistence();
        storyBundles = new HashMap<String, StoryBundle>();
        sceneStoryMap = new HashMap<String, String>();
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
     * @param persistenceImpl Instance of StoryPersistence to use
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
     * @param bundleToLoad Complete story JSON object to load into memory
     */
    public void loadStoryBundle(StoryBundle bundleToLoad) {
        String storyKey = bundleToLoad.getStory().getKey();
        if (storyKey == null) {
            throw new IllegalArgumentException("Story must already have key.");
        }
        if (storyBundles.containsKey(storyKey)) {
            LOG.warn("Given story key already in use.  Replacing.");
        }
        storyBundles.put(storyKey, bundleToLoad);

        for (Scene sceneInBundle : bundleToLoad.getScenes()) {
            mapSceneToStory(sceneInBundle.getKey(), storyKey);
        }
    }

    /**
     * Adds a story to repository.  New stories without a key can be added.  The story that is returned will
     * have a new unique key and empty first scene assigned.
     *
     * @param story New story to add to repository
     * @return Story with newly assigned key
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

        StoryBundle bundle = new StoryBundle();
        bundle.setStory(story);
        storyBundles.put(story.getKey(), bundle);

        // new stories need a first scene
        Scene firstScene = addScene(tempKey, Scene.createNew("First scene", "Scene One", "Open your story"));
        story.setFirstScene(firstScene.getKey());
        bundle.addScene(firstScene);

        storage.saveStory(bundle);
        return story;
    }

    public Story getStory(String storyKey) {
        return storyBundles.get(storyKey).getStory();
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

    public void removeStory(String storyKey) {
        StoryBundle bundle = storyBundles.get(storyKey);
        if (bundle == null) {
            LOG.warn("Story to be removed was not found; doing nothing.");
            return;
        }
        // get scenes out of map
        for (Scene scene : bundle.getScenes()) {
            sceneStoryMap.remove(scene.getKey());
        }
        storyBundles.remove(storyKey);
        storage.deleteStory(bundle);
    }

    /**
     * Returns all stories in repository.
     *
     * TODO This will be a problem at scale.
     *
     * @return
     */
    public List<Story> getStories() {
        List<Story> out = new ArrayList<Story>();
        for (StoryBundle bundle : storyBundles.values()) {
            out.add(bundle.getStory());
        }
        return out;
    }

    public Scene addScene(String storyKey, Scene scene) {
        StoryBundle bundle = storyBundles.get(storyKey);
        if (bundle == null) {
            throw new IllegalArgumentException("Story not found for given key");
        }
        if (scene.getKey() == null) {
            String tempKey;
            do {
                tempKey = keyGenerator.nextKey();
            } while (sceneStoryMap.containsKey(tempKey));
            scene.setKey(tempKey);
        }
        bundle.addScene(scene);
        mapSceneToStory(scene.getKey(), storyKey);
        return scene;
    }

    private void mapSceneToStory(String sceneKey, String storyKey) {
        sceneStoryMap.put(sceneKey, storyKey);
    }
    /**
     * Returns Scene for given key
     *
     * @param sceneKey Scene key of scene to get
     * @return Scene
     */
    public Scene getScene(String sceneKey) {
        String storyKey = sceneStoryMap.get(sceneKey);
        StoryBundle bundle = storyBundles.get(storyKey);
        return bundle.getScene(sceneKey);
    }

    /**
     * Add new scene as an option of the scene with the given key.
     *
     * @param parentSceneKey Key of the preceding scene
     * @param nextScene new scene
     * @return new scene with new key
     */
    public Scene addNextScene(String parentSceneKey, Scene nextScene) {

        // get story key
        String storyKey = sceneStoryMap.get(parentSceneKey);

        // add scene
        StoryBundle bundle = storyBundles.get(storyKey);
        bundle.addScene(nextScene);

        // update parent scene next options
        Scene parentScene = bundle.getScene(parentSceneKey);
        parentScene.addNextSceneOption(nextScene.getKey());

        return nextScene;
    }

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
