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

    public void login(String username, String password) {
        System.out.println("Admin logged in with username: " + username);
    }

    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course created: " + course.getName());
    }

    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered: " + student.getName());
    }

    public void registerInstructor(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor registered: " + instructor.getName());
    }

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

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }
}
