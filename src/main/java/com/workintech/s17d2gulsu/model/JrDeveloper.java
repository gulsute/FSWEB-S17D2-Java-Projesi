package com.workintech.s17d2gulsu.model;

public class JrDeveloper extends Developer{
    public JrDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
