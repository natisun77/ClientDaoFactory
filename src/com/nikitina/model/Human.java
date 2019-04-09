package com.nikitina.model;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private String id;
    private String email;

    public Human(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
