package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by dave on 5/16/15.
 */
public class Chapter {

    private Adventure story;

    @JsonProperty
    private String key;

    @JsonProperty
    private String teaser;

    @JsonProperty
    private String heading;

    @JsonProperty
    private String prose;

    @JsonProperty
    private List<Chapter> nextChapterOptions;

}
