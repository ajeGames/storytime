package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the join between one chapter and the available next chapters.  For each transition, an engaging story
 * will offer at least a couple of alternatives.  For now, the properties of each "sign" (option) amount to a chapter
 * ID and the text to be shown in the context of the chapter the reader is moving from.
 */
public class Signpost {

    private Integer fromChapterId;
    private List<ChapterSign> nextChapterOptions;  // TODO order signs on post

    @JsonProperty
    public Integer getFromChapterId() {
        return fromChapterId;
    }

    @JsonProperty
    public void setFromChapterId(Integer fromChapterId) {
        this.fromChapterId = fromChapterId;
    }

    @JsonProperty
    public List<ChapterSign> getNextChapterOptions() {
        return nextChapterOptions;
    }

    @JsonProperty
    public void setNextChapterOptions(List<ChapterSign> nextChapterOptions) {
        this.nextChapterOptions = nextChapterOptions;
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

        if (fromChapterId != null ? !fromChapterId.equals(signpost.fromChapterId) : signpost.fromChapterId != null)
            return false;
        return !(nextChapterOptions != null ? !nextChapterOptions.equals(signpost.nextChapterOptions) : signpost.nextChapterOptions != null);

    }

    @Override
    public int hashCode() {
        int result = fromChapterId != null ? fromChapterId.hashCode() : 0;
        result = 31 * result + (nextChapterOptions != null ? nextChapterOptions.hashCode() : 0);
        return result;
    }
}
