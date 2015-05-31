package com.ajegames.storytime.resource.view;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NextChapter getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(NextChapter firstChapter) {
        this.firstChapter = firstChapter;
    }
}
