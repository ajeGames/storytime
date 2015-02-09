package com.ajegames.storytime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>Scene</code> holds a snippet of a story and includes a number of options that allow the reader to
 * choose the next step.
 */
public class Scene {

    private String key;
    private String summary;
    private String content;
    private List<Scene> choices;

    private Scene() {
        choices = new ArrayList<Scene>();
    }

    private Scene(String key, String summary, String content) {
        this.key = key;
        this.summary = summary;
        this.content = content;
        choices = new ArrayList<Scene>();
    }

    public static Scene createEmptyScene() {
        return new Scene();
    }

    public static Scene loadScene(String key, String summary, String content) {
        return new Scene(key, summary, content);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Scene> getChoices() {
        return choices;
    }

    public void addChoice(Scene choice) {
        choices.add(choice);
    }

}
