package com.github._2kays.osu.lobsterapi.model;

import javax.persistence.*;

@Entity(name = "lobster")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING
)
public class Lobster {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Type is a table discriminator, so we don't want unchecked modifications.
    // However, it's also useful to expose to API users, hence why we specify it here.
    @Column(insertable = false, updatable = false)
    private String type;

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

