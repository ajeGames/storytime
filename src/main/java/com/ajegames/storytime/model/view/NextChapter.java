package com.ajegames.storytime.model.view;

import com.ajegames.storytime.model.Chapter;

public class NextChapter {

    private Integer id;
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
}
