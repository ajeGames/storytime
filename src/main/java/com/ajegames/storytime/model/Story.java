package com.ajegames.storytime.model;

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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Scene getFirstScene() {
        return firstScene;
    }
}
