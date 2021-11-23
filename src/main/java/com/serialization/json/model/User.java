package com.serialization.json.model;

import java.util.Map;

public class User {
    public int id;
    public String name;
    public Map<String, String> attributes;

    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public Map<String, String> getAttributes() {

        return attributes;
    }
    public void setAttributes(Map<String, String> attributes) {

        this.attributes = attributes;
    }
}
