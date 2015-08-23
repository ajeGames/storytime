package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the join between one chapter and the available next chapters.  For each transition, an engaging story
 * will offer at least a couple of alternatives.  For now, the properties of each "sign" (option) amount to a chapter
 * ID and the text to be shown in the context of the chapter the reader is moving from.
 */
public class Signpost {

    @JsonProperty
    private Integer fromChapterId;

    @JsonProperty
    private List<Sign> options;

    // TODO implement
}
