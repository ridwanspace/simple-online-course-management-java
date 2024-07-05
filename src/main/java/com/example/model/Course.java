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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }
}
