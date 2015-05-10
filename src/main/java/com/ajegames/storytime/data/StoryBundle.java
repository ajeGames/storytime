package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Scene;
import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents how stories are persisted to file, which is different from how they are presented to UI.
 */
public class StoryBundle {

    @JsonProperty
    private Story story;

    @JsonProperty
    private List<Scene> scenes;

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
    }

    public void addScene(Scene scene) {
        this.scenes.add(scene);
    }
}
