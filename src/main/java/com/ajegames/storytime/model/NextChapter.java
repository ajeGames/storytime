package com.ajegames.storytime.model;

/**
 * Created by dave on 5/22/15.
 */
public class NextChapter {

    private Integer parentID;
    private String teaser;

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}
