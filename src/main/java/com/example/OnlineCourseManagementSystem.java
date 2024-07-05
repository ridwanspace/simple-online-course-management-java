package com.example;

import com.example.controller.AdminController;
import com.example.controller.InstructorController;
import com.example.controller.StudentController;
import com.example.model.Course;
import com.example.model.Instructor;
import com.example.model.Student;

public class OnlineCourseManagementSystem {

    /**
     * The main function of the OnlineCourseManagementSystem.
     *
     * @param  args   the command line arguments
     */
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        InstructorController instructorController = new InstructorController();
        StudentController studentController = new StudentController();

        // Simulate some operations
        adminController.login("admin", "password");
        instructorController.login("instructor", "password");
        studentController.login("student", "password");

        // Create course and student objects
        Course math101 = new Course("Math 101");
        Student johnDoe = new Student("John Doe");
        Instructor drSmith = new Instructor("Dr. Smith");

        // Create courses and register students
        adminController.createCourse(math101);
        adminController.registerStudent(johnDoe);
        adminController.assignInstructor(math101.getName(), drSmith.getName());

        // Instructor creates and grades assignments
        instructorController.createAssignment(math101.getName(), "Assignment 1");
        instructorController.gradeAssignment(math101.getName(), "Assignment 1", johnDoe.getName(), 90);

        // Generate reports
        adminController.generateNumberOfStudentsPerInstructorReport();
        adminController.generateNumberOfAppliedCoursesPerStudentReport();
    }
}
