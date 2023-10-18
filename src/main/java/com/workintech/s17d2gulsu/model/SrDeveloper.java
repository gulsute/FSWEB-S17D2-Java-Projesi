package com.workintech.s17d2gulsu.model;

public class SrDeveloper extends Developer{
    public SrDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}
