package com.exampel.spring.cloud.feign.person.service.provider.entity;

import javax.persistence.*;

/**
 * Created by kyle on 2018/10/31.
 */
@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue
    private long id;
    @Column
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
