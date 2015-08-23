package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to explain one of the options before our fair reader.  The chapter ID is that of the chapter the reader will
 * be taken to if selected.  The teaser is what the reader will presented in order to choose an option.
 */
public class ChapterSign {

    private Integer targetChapterId;
    private String teaser;

    public static ChapterSign createExisting(Integer targetChapterId, String teaser) {
        ChapterSign sign = new ChapterSign();
        sign.setTargetChapterId(targetChapterId);
        sign.setTeaser(teaser);
        return sign;
    }

    @JsonProperty
    public Integer getTargetChapterId() {
        return targetChapterId;
    }

    @JsonProperty
    public void setTargetChapterId(Integer targetChapterId) {
        this.targetChapterId = targetChapterId;
    }

    @JsonProperty
    public String getTeaser() {
        return teaser;
    }

    @JsonProperty
    public void setTeaser(String teaser) {
        this.teaser = teaser;
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

        if (targetChapterId != null ? !targetChapterId.equals(that.targetChapterId) : that.targetChapterId != null)
            return false;
        return !(teaser != null ? !teaser.equals(that.teaser) : that.teaser != null);

    }

    @Override
    public int hashCode() {
        int result = targetChapterId != null ? targetChapterId.hashCode() : 0;
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        return result;
    }
}
