package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Representation for the chapter.
 */
public class Chapter implements Comparable {

    private Integer id;
    private String heading;
    private String prose;
    private List<ChapterSign> nextChapterOptions;

    public static Chapter create(final Integer id, final String heading, final String prose,
                                 final List<ChapterSign> options) {
        Chapter chapter = new Chapter();
        chapter.id = id;
        chapter.heading = heading;
        chapter.prose = prose;
        chapter.nextChapterOptions = options;
        return chapter;
    }

    public static Chapter createWithPlaceholderText(Integer id) {
        Chapter chapter = new Chapter();
        chapter.id = id;
        chapter.heading = "Name This Chapter";
        chapter.prose = "Say what happens...";
        return chapter;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getHeading() {
        return heading;
    }

    @JsonProperty
    public String getProse() {
        return prose;
    }

    @JsonProperty
    public List<ChapterSign> getNextChapterOptions() {
        return nextChapterOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equal(id, chapter.id) &&
                Objects.equal(heading, chapter.heading) &&
                Objects.equal(prose, chapter.prose) &&
                Objects.equal(nextChapterOptions, chapter.nextChapterOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, heading, prose, nextChapterOptions);
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

    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        if (o == null) return -1;  // force null objects to the end

        Chapter chapter = (Chapter) o;
        if (id.equals(chapter.getId())) return 0;
        return (id < chapter.getId()) ? -1 : 1;
    }
}
