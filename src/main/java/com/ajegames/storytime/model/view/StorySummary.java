package com.ajegames.storytime.model.view;

import com.ajegames.storytime.model.Story;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StorySummary {

    @JsonProperty
    private String key;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String tagLine;

    @JsonProperty
    private String description;

    @JsonProperty
    private NextChapter firstChapter;

    public static StorySummary createFromStory(Story story) {
        StorySummary summary = new StorySummary();
        summary.key = story.getKey();
        summary.title = story.getTitle();
        summary.author = story.getAuthor();
        summary.tagLine = story.getTagLine();
        summary.description = story.getDescription();
        summary.firstChapter = NextChapter.createFromChapter(story.getFirstChapter());
        return summary;
    }
}
