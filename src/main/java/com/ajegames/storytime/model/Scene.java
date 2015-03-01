package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * All information about a scene, including summaries of the next scene options.
 */
public class Scene extends SceneSummary {

    @JsonProperty
    private String heading;

    @JsonProperty
    private String prose;

    @JsonProperty
    private List<SceneSummary> nextSceneOptions;

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

    public List<SceneSummary> getNextSceneOptions() {
        return nextSceneOptions;
    }

    public void setNextSceneOptions(List<SceneSummary> nextSceneOptions) {
        this.nextSceneOptions = nextSceneOptions;
    }
}
