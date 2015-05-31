package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Chapter {

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

    public static Chapter create(Story story, Integer id) {
        Chapter out = new Chapter();
        out.setId(id);
        return out;
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

    public void setNextChapterOptions(List<Chapter> options) {
        if (options == null) {
            throw new IllegalArgumentException("Expecting non-null list of chapters");
        }
        this.nextChapterOptions.clear();
        for (Chapter chap : options) {
            addNextChapter(chap);
        }
    }

    public void addNextChapter(Chapter next) {
        this.nextChapterOptions.add(next);
    }

    public boolean hasNext() {
        return nextChapterOptions != null || !nextChapterOptions.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (id != null ? !id.equals(chapter.id) : chapter.id != null) return false;
        if (teaser != null ? !teaser.equals(chapter.teaser) : chapter.teaser != null) return false;
        if (heading != null ? !heading.equals(chapter.heading) : chapter.heading != null) return false;
        if (prose != null ? !prose.equals(chapter.prose) : chapter.prose != null) return false;
        return !(nextChapterOptions != null ? !nextChapterOptions.equals(chapter.nextChapterOptions) : chapter.nextChapterOptions != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (prose != null ? prose.hashCode() : 0);
        result = 31 * result + (nextChapterOptions != null ? nextChapterOptions.hashCode() : 0);
        return result;
    }
}
