package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to explain one of the options before our fair reader.  The chapter ID is that of the chapter the reader will
 * be taken to if selected.  The description is what the reader will presented in order to choose an option.
 */
public class Sign {

    @JsonProperty
    private Integer toChapterId;

    @JsonProperty
    private String description;

    public Integer getToChapterId() {
        return toChapterId;
    }

    public void setToChapterId(Integer toChapterId) {
        this.toChapterId = toChapterId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sign sign = (Sign) o;

        if (toChapterId != null ? !toChapterId.equals(sign.toChapterId) : sign.toChapterId != null) return false;
        return !(description != null ? !description.equals(sign.description) : sign.description != null);

    }

    @Override
    public int hashCode() {
        int result = toChapterId != null ? toChapterId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
