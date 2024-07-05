package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Instructor instructor;
    private List<Student> students;
    private List<Assignment> assignments;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    /**
     * Gets the name of the course.
     *
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name the new name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the instructor associated with this course.
     *
     * @return the instructor associated with this course
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor for this course.
     *
     * @param  instructor   the Instructor object to be set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Retrieves the list of students enrolled in the course.
     *
     * @return a list of Student objects representing the students enrolled in the course
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the list of students.
     *
     * @param  student  the Student object to be added
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Retrieves the list of assignments associated with this course.
     *
     * @return a list of Assignment objects representing the assignments for this course
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Adds an assignment to the list of assignments.
     *
     * @param  assignment   the Assignment object to be added
     */
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }
}
