package com.ajegames.storytime;

import java.util.ArrayList;
import java.util.List;

/**
 * This is for...
 */
public class StoryNode {

    private String key;
    private String summary;
    private String content;
    private List<StoryNode> choices;

    public StoryNode(String key, String summary, String content) {
        this.key = key;
        this.summary = summary;
        this.content = content;
        choices = new ArrayList<StoryNode>();
    }

    public String getKey() {
        return key;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public List<StoryNode> getChoices() {
        return choices;
    }

    public void addChoice(StoryNode choice) {
        choices.add(choice);
    }
}
