package com.toptal.blog.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Emp {
    private String id;
    //@NotEmpty
    private String name;

    public Emp(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp(int ok200, Emp emp) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
