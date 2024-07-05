package com.example;

import com.example.model.*;
import com.example.controller.AdminController;

public class DataInitializer {
    public static void initialize(AdminController adminController) {
        // Create instructors
        Instructor instructor1 = new Instructor("Dr. Smith");
        Instructor instructor2 = new Instructor("Dr. Johnson");
        Instructor instructor3 = new Instructor("Dr. Brown");
        Instructor instructor4 = new Instructor("Dr. Miller");
        Instructor instructor5 = new Instructor("Dr. Davis");

        adminController.registerInstructor(instructor1);
        adminController.registerInstructor(instructor2);
        adminController.registerInstructor(instructor3);
        adminController.registerInstructor(instructor4);
        adminController.registerInstructor(instructor5);

        // Create courses and assign instructors
        Course course1 = new Course("Math 101");
        Course course2 = new Course("Physics 101");
        Course course3 = new Course("Chemistry 101");
        Course course4 = new Course("Biology 101");
        Course course5 = new Course("History 101");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);
        course4.setInstructor(instructor4);
        course5.setInstructor(instructor5);

        adminController.createCourse(course1);
        adminController.createCourse(course2);
        adminController.createCourse(course3);
        adminController.createCourse(course4);
        adminController.createCourse(course5);

        // Register students
        Student student1 = new Student("John Doe");
        Student student2 = new Student("Jane Doe");
        Student student3 = new Student("Alice Smith");
        Student student4 = new Student("Bob Johnson");
        Student student5 = new Student("Charlie Brown");

        adminController.registerStudent(student1);
        adminController.registerStudent(student2);
        adminController.registerStudent(student3);
        adminController.registerStudent(student4);
        adminController.registerStudent(student5);

        // Enroll students in courses
        course1.addStudent(student1);
        course1.addStudent(student2);
        course2.addStudent(student3);
        course3.addStudent(student4);
        course4.addStudent(student5);
        course5.addStudent(student1);
        course5.addStudent(student2);
        course5.addStudent(student3);
        course5.addStudent(student4);
        course5.addStudent(student5);

        // Create assignments
        Assignment assignment1 = new Assignment("Assignment 1");
        Assignment assignment2 = new Assignment("Assignment 2");

        course1.addAssignment(assignment1);
        course2.addAssignment(assignment2);
    }
}
