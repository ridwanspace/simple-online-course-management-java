package com.example.controller;

import com.example.model.Course;
import com.example.model.Student;
import com.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private List<Course> courses;
    private List<Student> students;
    private List<Instructor> instructors;

    public AdminController() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    /**
     * Logs in the admin with the given username and password.
     *
     * @param  username  the username of the admin
     * @param  password  the password of the admin
     */
    public void login(String username, String password) {
        System.out.println("Admin logged in with username: " + username);
    }

    /**
     * Adds a new course to the list of courses and prints a message indicating the course creation.
     *
     * @param  course  the Course object to be added
     */
    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course created: " + course.getName());
    }

    /**
     * Registers a student by adding them to the list of students and printing a message indicating the student's registration.
     *
     * @param  student  the Student object to be registered
     */
    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered: " + student.getName());
    }

    /**
     * Registers an instructor by adding them to the list of instructors and printing a message indicating the instructor's registration.
     *
     * @param  instructor  the Instructor object to be registered
     */
    public void registerInstructor(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor registered: " + instructor.getName());
    }

    /**
     * Assigns an instructor to a course.
     *
     * @param  courseName    the name of the course
     * @param  instructorName the name of the instructor
     */
    public void assignInstructor(String courseName, String instructorName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                for (Instructor instructor : instructors) {
                    if (instructor.getName().equals(instructorName)) {
                        course.setInstructor(instructor);
                        System.out.println("Instructor " + instructorName + " assigned to course: " + courseName);
                        return;
                    }
                }
            }
        }
        System.out.println("Instructor or course not found");
    }

    /**
     * Applies a student to a course.
     *
     * @param  studentName   the name of the student
     * @param  courseName    the name of the course
     */
    public void applyCourse(String studentName, String courseName) {
        Student student = null;
        Course course = null;

        for (Student s : students) {
            if (s.getName().equals(studentName)) {
                student = s;
                break;
            }
        }

        for (Course c : courses) {
            if (c.getName().equals(courseName)) {
                course = c;
                break;
            }
        }

        if (student != null && course != null) {
            course.addStudent(student);
            System.out.println("Student " + studentName + " applied to course: " + courseName);
        } else {
            System.out.println("Student or course not found");
        }
    }

    /**
     * Generates a report that displays the number of students per instructor.
     *
     * @return  a string containing the report with the number of students per instructor
     */
    public String generateNumberOfStudentsPerInstructorReport() {
        StringBuilder report = new StringBuilder();
        for (Instructor instructor : instructors) {
            int studentCount = 0;
            for (Course course : courses) {
                if (course.getInstructor() != null && course.getInstructor().getName().equals(instructor.getName())) {
                    studentCount += course.getStudents().size();
                }
            }
            report.append("Instructor ").append(instructor.getName()).append(" has ").append(studentCount).append(" students.\n");
        }
        return report.toString();
    }

    /**
     * Generates a report that displays the number of applied courses per student.
     *
     * @return  a string containing the report with the number of applied courses per student
     */
    public String generateNumberOfAppliedCoursesPerStudentReport() {
        StringBuilder report = new StringBuilder();
        for (Student student : students) {
            int courseCount = 0;
            for (Course course : courses) {
                if (course.getStudents().contains(student)) {
                    courseCount++;
                }
            }
            report.append("Student ").append(student.getName()).append(" has applied to ").append(courseCount).append(" courses.\n");
        }
        return report.toString();
    }

    /**
     * Returns a list of courses.
     *
     * @return a list of Course objects representing the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Returns a list of students.
     *
     * @return          a list of Student objects representing the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Returns a list of instructors.
     *
     * @return          a list of Instructor objects representing the instructors
     */
    public List<Instructor> getInstructors() {
        return instructors;
    }
}
