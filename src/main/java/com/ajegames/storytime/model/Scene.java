package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * All information about a scene, including summaries of the next scene options.
 */
public class Scene {

    @JsonProperty
    private String key;

    @JsonProperty
    private String teaser;

    @JsonProperty
    private String heading;

    @JsonProperty
    private String prose;

    @JsonProperty
    private List<String> nextSceneOptions;

    public static Scene load(String key, String teaser, String heading, String prose) {
        Scene scene = new Scene();
        scene.setTeaser(teaser);
        scene.setHeading(heading);
        scene.setProse(prose);
        return scene;
    }

    public static Scene create(String teaser, String heading, String prose) {
        Scene scene = new Scene();
        scene.setTeaser(teaser);
        scene.setHeading(heading);
        scene.setProse(prose);
        return scene;
    }

    public static Scene create(SceneSummary summary) {
        Scene scene = new Scene();
        scene.setKey(summary.getKey());
        scene.setTeaser(summary.getTeaser());
        return scene;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getProse() {
        return prose;
    }

    public void setProse(String prose) {
        this.prose = prose;
    }

    public List<String> getNextSceneOptions() {
        return nextSceneOptions;
    }

    public void setNextSceneOptions(List<String> nextSceneOptions) {
        this.nextSceneOptions = new ArrayList<String>();
        this.nextSceneOptions.addAll(nextSceneOptions);
    }

    public void addNextSceneOption(String anotherOption) {
        if (this.nextSceneOptions == null) {
            this.nextSceneOptions = new ArrayList<String>();
        }
        this.nextSceneOptions.add(anotherOption);
    }

    public SceneSummary generateSummary() {
        SceneSummary out = new SceneSummary();
        out.setKey(getKey());
        out.setTeaser(getTeaser());
        return out;
    }
}
