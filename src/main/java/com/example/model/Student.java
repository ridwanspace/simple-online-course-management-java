package com.example.model;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return the name of the student as a string
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
