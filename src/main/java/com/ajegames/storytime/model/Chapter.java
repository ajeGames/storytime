package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 5/16/15.
 */
public class Chapter {

    @JsonIgnore
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

    public Chapter() {
        nextChapterOptions = new ArrayList<Chapter>();
    }

    public static Chapter create(Adventure story, Integer id) {
        Chapter out = new Chapter();
        out.story = story;
        out.setId(id);
        return out;
    }

    @JsonIgnore
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

    public List<Chapter> getNextChapterOptions() {
        return nextChapterOptions;
    }

    public void setNextChapterOptions(List<Chapter> nextChapterOptions) {
        if (nextChapterOptions == null) {
            throw new IllegalArgumentException("Expecting non-null list of chapters");
        }
        nextChapterOptions.clear();
        for (Chapter chap : nextChapterOptions) {
            nextChapterOptions.add(chap);
        }
        this.nextChapterOptions = nextChapterOptions;
    }

    public void addNextChapter(Chapter next) {
        this.nextChapterOptions.add(next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (story != null ? !story.equals(chapter.story) : chapter.story != null) return false;
        if (id != null ? !id.equals(chapter.id) : chapter.id != null) return false;
        if (teaser != null ? !teaser.equals(chapter.teaser) : chapter.teaser != null) return false;
        if (heading != null ? !heading.equals(chapter.heading) : chapter.heading != null) return false;
        if (prose != null ? !prose.equals(chapter.prose) : chapter.prose != null) return false;
        return !(nextChapterOptions != null ? !nextChapterOptions.equals(chapter.nextChapterOptions) : chapter.nextChapterOptions != null);

    }

    @Override
    public int hashCode() {
        int result = story != null ? story.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (prose != null ? prose.hashCode() : 0);
        result = 31 * result + (nextChapterOptions != null ? nextChapterOptions.hashCode() : 0);
        return result;
    }
}
