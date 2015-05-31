package com.ajegames.storytime.view;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandaloneChapter that = (StandaloneChapter) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (heading != null ? !heading.equals(that.heading) : that.heading != null) return false;
        if (prose != null ? !prose.equals(that.prose) : that.prose != null) return false;
        return !(nextChapterOptions != null ? !nextChapterOptions.equals(that.nextChapterOptions) : that.nextChapterOptions != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (prose != null ? prose.hashCode() : 0);
        result = 31 * result + (nextChapterOptions != null ? nextChapterOptions.hashCode() : 0);
        return result;
    }
}
