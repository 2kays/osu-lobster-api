package com.github._2kays.osu.lobsterapi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("spiny")
public class SpinyLobster extends Lobster {

    // Example spineCount field to distinguish Spiny from Clawed lobsters.
    // Mostly here to make the Controller/Service code more interesting.
    // Corresponds to "spineCount" field in the JSON API
    private Integer spineCount;

    public Integer getSpineCount() {
        return spineCount;
    }

    public void setSpineCount(Integer spineCount) {
        this.spineCount = spineCount;
    }
}
