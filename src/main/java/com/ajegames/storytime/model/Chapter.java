package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the chapter.
 */
public class Chapter implements Comparable {

    private Story myStory;  // remember story that chapter belongs to
    private Integer id;
    private String heading;
    private String prose;
    private List<ChapterSign> nextChapterOptions;

    public Chapter() {
        nextChapterOptions = new ArrayList<ChapterSign>();
    }

    public static Chapter create(Story story, Integer id, String heading, String prose) {
        Chapter out = new Chapter();
        out.setMyStory(story);
        out.setId(id);
        out.setHeading(heading);
        out.setProse(prose);
        return out;
    }

    public static Chapter createWithPlaceholderText(Story story, Integer id) {
        Chapter out = new Chapter();
        out.setMyStory(story);
        out.setId(id);
        out.setHeading("Name This Chapter");
        out.setProse("Say what happens...");
        return out;
    }

    @JsonIgnore
    public Story getMyStory() {
        return myStory;
    }

    @JsonIgnore
    private void setMyStory(Story myStory) {
        this.myStory = myStory;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty
    public String getHeading() {
        return heading;
    }

    @JsonProperty
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @JsonProperty
    public String getProse() {
        return prose;
    }

    @JsonProperty
    public void setProse(String prose) {
        this.prose = prose;
    }

    @JsonProperty
    public List<ChapterSign> getNextChapterOptions() {
        return nextChapterOptions;
    }

    @JsonProperty
    public void setNextChapterOptions(List<ChapterSign> options) {
        if (options == null) {
            throw new IllegalArgumentException("Expecting non-null list of chapters");
        }
        this.nextChapterOptions.clear();
        for (ChapterSign chap : options) {
            addNextChapter(chap);
        }
    }

    public void addNextChapter(ChapterSign next) {
        this.nextChapterOptions.add(next);
    }

    public boolean hasNext() {
        return nextChapterOptions != null || !nextChapterOptions.isEmpty();
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", prose='" + prose + '\'' +
                ", nextChapterOptions=" + nextChapterOptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (id != null ? !id.equals(chapter.id) : chapter.id != null) return false;
        if (heading != null ? !heading.equals(chapter.heading) : chapter.heading != null) return false;
        if (prose != null ? !prose.equals(chapter.prose) : chapter.prose != null) return false;
        return !(nextChapterOptions != null ? !nextChapterOptions.equals(chapter.nextChapterOptions) : chapter.nextChapterOptions != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (prose != null ? prose.hashCode() : 0);
        result = 31 * result + (nextChapterOptions != null ? nextChapterOptions.hashCode() : 0);
        return result;
    }

    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        if (o == null) return -1;  // force null objects to the end

        Chapter chapter = (Chapter) o;
        if (id.equals(chapter.getId())) return 0;
        return (id < chapter.getId()) ? -1 : 1;
    }
}
