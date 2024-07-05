package com.example.model;

public class Assignment {
    private String name;
    private int grade;

    public Assignment(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the assignment.
     *
     * @return          the name of the assignment
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the assignment.
     *
     * @param  name  the new name of the assignment
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the grade of the assignment.
     *
     * @return          the grade of the assignment
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the assignment.
     *
     * @param  grade  the new grade of the assignment
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
