package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by dave on 5/16/15.
 */
public class Chapter {

    private Adventure story;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String teaser;

    @JsonProperty
    private String heading;

    @JsonProperty
    private String prose;

    @JsonProperty
    private List<Chapter> nextChapterOptions;

    public static Chapter create(Adventure story, Integer id) {
        Chapter out = new Chapter();
        out.story = story;
        out.setId(id);
        return out;
    }

    public Adventure getStory() {
        return story;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
