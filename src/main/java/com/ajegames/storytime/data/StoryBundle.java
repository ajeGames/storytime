package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * Represents how stories are persisted to file, which is different from how they are presented to UI.
 */
public class StoryBundle {

    @JsonProperty
    private Story story;

    @JsonProperty
    private List<Scene> scenes = new ArrayList<Scene>();

    private Map<String, Scene> sceneIndex = new HashMap<String, Scene>();

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
        for (Scene aScene : scenes) {
            this.sceneIndex.put(aScene.getKey(), aScene);
        }
    }

    public Scene getScene(String sceneKey) {
        return sceneIndex.get(sceneKey);
    }

    public void addScene(Scene scene) {
        this.scenes.add(scene);
        this.sceneIndex.put(scene.getKey(), scene);
    }

    public void removeScene(String keyOfSceneToRemove) {
        sceneIndex.remove(keyOfSceneToRemove);
        Iterator<Scene> iter = scenes.iterator();
        while(iter.hasNext()) {
            Scene myScene = iter.next();
            if (myScene.getKey().equals(keyOfSceneToRemove)) {
                iter.remove();
                break;
            }
        }
    }
}
