package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <code>Story</code> holds information about the story, including title and a brief description to entice the curious reader.
 * It also points to the beginning of the story.
 */
public class Story {

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
    private String firstScene;

    public static Story create(String title, String author, String tagLine, String description, String firstScene) {
        Story out = new Story();
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setDescription(description);
        out.setFirstScene(firstScene);
        return out;
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

    public String getFirstScene() {
        return firstScene;
    }

    public void setFirstScene(String firstScene) {
        this.firstScene = firstScene;
    }
}
