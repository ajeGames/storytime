package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <code>Story</code> holds information about the story, including title and a brief description to entice the curious reader.
 * It also points to the beginning of the story.
 */
public class Story {

    private String title;
    private String author;
    private String description;
    private Scene firstScene;

    private Story(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        firstScene = Scene.createEmptyScene();
    }

    public static Story createStory(String title, String author, String description) {
        return new Story(title, author, description);
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public Scene getFirstScene() {
        return firstScene;
    }
}
