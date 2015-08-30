package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the join between one chapter and the available next chapters.  For each transition, an engaging story
 * will offer at least a couple of alternatives.  For now, the properties of each "sign" (option) amount to a chapter
 * ID and the text to be shown in the context of the chapter the reader is moving from.
 */
public class Signpost {

    private Integer fromChapterId;
    private List<ChapterSign> nextChapterOptions;

    public static Signpost create(final Integer fromChapterId, List<ChapterSign> chapterOptions) {
        Signpost post = new Signpost();
        post.fromChapterId = fromChapterId;
        post.nextChapterOptions = new ArrayList<ChapterSign>(chapterOptions);  // TODO make immutable list
        return post;
    }

    @JsonProperty
    public Integer getFromChapterId() {
        return fromChapterId;
    }

    @JsonProperty
    public List<ChapterSign> getNextChapterOptions() {
        return nextChapterOptions;
    }

    @Override
    public String toString() {
        return "Signpost{" +
                "fromChapterId=" + fromChapterId +
                ", nextChapterOptions=" + nextChapterOptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signpost signpost = (Signpost) o;
        return Objects.equal(fromChapterId, signpost.fromChapterId) &&
                Objects.equal(nextChapterOptions, signpost.nextChapterOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fromChapterId, nextChapterOptions);
    }
}
