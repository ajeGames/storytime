package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Summary information about a scene.
 */
public class SceneSummary {

    @JsonProperty
    private String key;

    @JsonProperty
    private String teaser;

    public static SceneSummary create(String teaser) {
        SceneSummary summary = new SceneSummary();
        summary.setTeaser(teaser);
        return summary;
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
}
