package com.exampel.spring.cloud.feign.api.domain;

/**
 * Created by kyle on 2018/10/16.
 */
public class Person {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
