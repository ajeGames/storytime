package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents how stories are persisted to file, which is different from how they are presented to UI.
 */
public class StoryGraph {

    @JsonProperty
    private Story story;

    @JsonProperty
    private List<Scene> scenes;

    private Map<String, Scene> sceneMap;

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
        this.sceneMap = new HashMap<String, Scene>();
        for (Scene scene : scenes) {
            sceneMap.put(scene.getKey(), scene);
        }
    }

    public void addScene(Scene scene) {
        this.scenes.add(scene);
        this.sceneMap.put(scene.getKey(), scene);
    }

    public Scene getScene(String key) {
        return this.sceneMap.get(key);
    }
}
