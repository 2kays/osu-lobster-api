package com.github._2kays.osu.lobsterapi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("clawed")
public class ClawedLobster extends Lobster {
}
