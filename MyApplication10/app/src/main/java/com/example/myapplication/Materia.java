package com.example.myapplication;

public class Materia {
    private String name;
    private String description;

    public Materia(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
