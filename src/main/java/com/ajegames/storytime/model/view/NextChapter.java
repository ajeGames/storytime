package com.ajegames.storytime.model.view;

import com.ajegames.storytime.model.Chapter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NextChapter {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String teaser;

    public static NextChapter createFromChapter(Chapter chapter) {
        NextChapter next = new NextChapter();
        next.id = chapter.getId();
        next.teaser = chapter.getTeaser();
        return next;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NextChapter that = (NextChapter) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(teaser != null ? !teaser.equals(that.teaser) : that.teaser != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        return result;
    }
}
