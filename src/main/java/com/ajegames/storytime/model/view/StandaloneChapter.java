package com.ajegames.storytime.model.view;

import com.ajegames.storytime.model.Chapter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 5/30/15.
 */
public class StandaloneChapter {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String teaser;

    @JsonProperty
    private String heading;

    @JsonProperty
    private String prose;

    @JsonProperty
    private List<NextChapter> nextChapterOptions;

    public static StandaloneChapter createFromChapter(Chapter chapter) {
        StandaloneChapter out = new StandaloneChapter();
        out.id = chapter.getId();
        out.teaser = chapter.getTeaser();
        out.heading = chapter.getHeading();
        out.prose = chapter.getProse();
        out.nextChapterOptions = new ArrayList<NextChapter>();
        if (chapter.hasNext()) {
            for (Chapter next : chapter.getNextChapterOptions()) {
                out.nextChapterOptions.add(NextChapter.createFromChapter(next));
            }
        }
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

    public List<NextChapter> getNextChapterOptions() {
        return nextChapterOptions;
    }

    public void setNextChapterOptions(List<NextChapter> nextChapterOptions) {
        this.nextChapterOptions = nextChapterOptions;
    }
}
