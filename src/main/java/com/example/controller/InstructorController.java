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

    /**
     * Logs in an instructor with the given username and password.
     *
     * @param  username  the username of the instructor
     * @param  password  the password of the instructor
     */
    public void login(String username, String password) {
        System.out.println("Instructor logged in with username: " + username);
    }

    /**
     * Creates an assignment for a course.
     *
     * @param  courseName     the name of the course
     * @param  assignmentName the name of the assignment
     * @return                void
     */
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

    /**
     * Grades an assignment for a student in a specific course.
     *
     * @param  courseName     the name of the course
     * @param  assignmentName the name of the assignment
     * @param  studentName    the name of the student
     * @param  grade         the grade to be assigned to the assignment
     */
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

    /**
     * Retrieves the list of courses.
     *
     * @return  a List of Course objects representing the courses
     */
    public List<Course> getCourses() {
        return courses;
    }
}
