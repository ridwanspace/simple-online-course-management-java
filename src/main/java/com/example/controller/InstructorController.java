package com.example.controller;

import com.example.model.Assignment;
import com.example.model.Course;

import java.util.ArrayList;
import java.util.List;

public class InstructorController {
    private List<Course> courses;

    public InstructorController() {
        this.courses = new ArrayList<>();
    }

    public void login(String username, String password) {
        System.out.println("Instructor logged in with username: " + username);
    }

    public void createAssignment(String courseName, String assignmentName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                Assignment assignment = new Assignment(assignmentName);
                course.addAssignment(assignment);
                System.out.println("Assignment created for course " + courseName + ": " + assignmentName);
                return;
            }
        }
        System.out.println("Course not found");
    }

    public void gradeAssignment(String courseName, String assignmentName, String studentName, int grade) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                for (Assignment assignment : course.getAssignments()) {
                    if (assignment.getName().equals(assignmentName)) {
                        assignment.setGrade(grade);
                        System.out.println("Assignment " + assignmentName + " for course " + courseName + " graded for student " + studentName + " with grade: " + grade);
                        return;
                    }
                }
            }
        }
        System.out.println("Course or assignment not found");
    }

    public List<Course> getCourses() {
        return courses;
    }
}
