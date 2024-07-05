package com.example.model;

public class Instructor {
    private String name;

    public Instructor(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the instructor.
     *
     * @return the name of the instructor as a string
     */
    public String getName() {
        return name;
    }

    /**
     * A description of the entire Java function.
     *
     * @param  name  description of parameter
     */
    public void setName(String name) {
        this.name = name;
    }
}
