package com.lunz.cpfw.web.entities;

import java.io.Serializable;

public class helloworld implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}