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

    public static Scene createNew(String teaser, String heading, String prose) {
        Scene scene = new Scene();
        scene.setTeaser(teaser);
        scene.setHeading(heading);
        scene.setProse(prose);
        return scene;
    }

    public static Scene createExisting(String key, String teaser, String heading, String prose) {
        Scene scene = new Scene();
        scene.setKey(key);
        scene.setTeaser(teaser);
        scene.setHeading(heading);
        scene.setProse(prose);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scene scene = (Scene) o;

        if (heading != null ? !heading.equals(scene.heading) : scene.heading != null) return false;
        if (key != null ? !key.equals(scene.key) : scene.key != null) return false;
        if (nextSceneOptions != null ? !nextSceneOptions.equals(scene.nextSceneOptions) : scene.nextSceneOptions != null)
            return false;
        if (prose != null ? !prose.equals(scene.prose) : scene.prose != null) return false;
        if (teaser != null ? !teaser.equals(scene.teaser) : scene.teaser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (prose != null ? prose.hashCode() : 0);
        result = 31 * result + (nextSceneOptions != null ? nextSceneOptions.hashCode() : 0);
        return result;
    }

    public void addNextSceneOption(String anotherOption) {
        if (this.nextSceneOptions == null) {
            this.nextSceneOptions = new ArrayList<String>();
        }
        this.nextSceneOptions.add(anotherOption);
    }
}
