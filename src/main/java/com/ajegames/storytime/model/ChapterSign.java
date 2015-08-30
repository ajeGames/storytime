package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Used to explain one of the options before our fair reader.  The chapter ID is that of the chapter the reader will
 * be taken to if selected.  The teaser is what the reader will presented in order to choose an option.
 */
public class ChapterSign {

    private Integer targetChapterId;
    private String teaser;

    public static ChapterSign create(final Integer targetChapterId, final String teaser) {
        final ChapterSign sign = new ChapterSign();
        sign.targetChapterId = targetChapterId;
        sign.teaser = teaser;
        return sign;
    }

    @JsonProperty
    public Integer getTargetChapterId() {
        return targetChapterId;
    }

    @JsonProperty
    public String getTeaser() {
        return teaser;
    }

    @Override
    public String toString() {
        return "ChapterSign{" +
                "targetChapterId=" + targetChapterId +
                ", teaser='" + teaser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterSign that = (ChapterSign) o;
        return Objects.equal(targetChapterId, that.targetChapterId) &&
                Objects.equal(teaser, that.teaser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(targetChapterId, teaser);
    }
}
