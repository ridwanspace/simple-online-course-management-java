package com.example.ui;

import com.example.DataInitializer;
import com.example.controller.AdminController;
import com.example.model.Course;
import com.example.model.Student;
import com.example.model.Instructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainUI extends JFrame {
    private JButton adminLoginButton;
    private JButton viewCoursesButton;
    private JButton viewStudentsButton;
    private JButton viewInstructorsButton;
    private JButton applyCourseButton;
    private JButton generateReportsButton;

    private AdminController adminController;

    public MainUI() {
        adminController = new AdminController();
        DataInitializer.initialize(adminController);  // Initialize dummy data

        createView();

        setTitle("Online Course Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Creates the view for the main UI.
     *
     * This method initializes a JPanel and adds it to the content pane of the main UI.
     * It then sets the layout of the panel to a GridLayout with 7 rows and 1 column,
     * and 10 horizontal and vertical gaps.
     *
     * It creates several JButtons for different actions, such as admin login, view courses,
     * view students, view instructors, apply course, and generate reports.
     *
     * It adds action listeners to each button, which will be handled by separate listeners
     * for admin login, view courses, view students, view instructors, apply course, and generate reports.
     *
     * Finally, it adds all the buttons to the panel.
     */
    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new GridLayout(7, 1, 10, 10));

        adminLoginButton = new JButton("Admin Login");
        viewCoursesButton = new JButton("View Courses");
        viewStudentsButton = new JButton("View Students");
        viewInstructorsButton = new JButton("View Instructors");
        applyCourseButton = new JButton("Apply Course");
        generateReportsButton = new JButton("Generate Reports");

        adminLoginButton.addActionListener(new AdminLoginButtonListener());
        viewCoursesButton.addActionListener(new ViewButtonListener());
        viewStudentsButton.addActionListener(new ViewButtonListener());
        viewInstructorsButton.addActionListener(new ViewButtonListener());
        applyCourseButton.addActionListener(new ApplyCourseButtonListener());
        generateReportsButton.addActionListener(new GenerateReportsButtonListener());

        panel.add(adminLoginButton);
        panel.add(viewCoursesButton);
        panel.add(viewStudentsButton);
        panel.add(viewInstructorsButton);
        panel.add(applyCourseButton);
        panel.add(generateReportsButton);
    }

    private class AdminLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Bypass username and password input
            adminController.login("admin", "password");

            String[] options = {"Instructor", "Course", "Student"};
            int choice = JOptionPane.showOptionDialog(null, "What would you like to input?", "Admin Input",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter Instructor Name:"));
                JTextField instructorField = new JTextField();
                panel.add(instructorField);
                panel.add(new JLabel("Enter Course Name:"));
                JTextField courseField = new JTextField();
                panel.add(courseField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Input Instructor and Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String instructorName = instructorField.getText();
                    String courseName = courseField.getText();
                    Instructor instructor = new Instructor(instructorName);
                    Course course = new Course(courseName);
                    course.setInstructor(instructor);
                    adminController.registerInstructor(instructor);
                    adminController.createCourse(course);
                }
            } else if (choice == 1) {
                String courseName = JOptionPane.showInputDialog("Enter Course Name:");
                adminController.createCourse(new Course(courseName));
            } else if (choice == 2) {
                String studentName = JOptionPane.showInputDialog("Enter Student Name:");
                adminController.registerStudent(new Student(studentName));
            }
        }
    }

    private class ViewButtonListener implements ActionListener {
    /**
     * Handles the action event when a button is clicked in the main UI.
     *
     * @param  e  the action event triggered by the button click
     */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == viewCoursesButton) {
                displayCourses();
            } else if (source == viewStudentsButton) {
                displayStudents();
            } else if (source == viewInstructorsButton) {
                displayInstructors();
            }
        }
    }

    private class ApplyCourseButtonListener implements ActionListener {
        /**
         * Performs an action event when a button is clicked in the main UI. 
         *
         * @param  e  the action event triggered by the button click
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> studentDropdown = new JComboBox<>();
            JComboBox<String> courseDropdown = new JComboBox<>();
            Map<String, Course> courseMap = new HashMap<>();

            for (Student student : adminController.getStudents()) {
                studentDropdown.addItem(student.getName());
            }

            for (Course course : adminController.getCourses()) {
                String displayText = course.getInstructor().getName() + " - " + course.getName();
                courseDropdown.addItem(displayText);
                courseMap.put(displayText, course);
            }

            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.add(new JLabel("Select Student:"));
            panel.add(studentDropdown);
            panel.add(new JLabel("Select Course:"));
            panel.add(courseDropdown);

            int result = JOptionPane.showConfirmDialog(null, panel, "Apply Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String studentName = (String) studentDropdown.getSelectedItem();
                String courseDisplayText = (String) courseDropdown.getSelectedItem();
                Course selectedCourse = courseMap.get(courseDisplayText);
                adminController.applyCourse(studentName, selectedCourse.getName());
            }
        }
    }

    private class GenerateReportsButtonListener implements ActionListener {
        /**
         * A method that handles the action performed event.
         *
         * @param  e    the ActionEvent triggering the action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] options = {"Students per Instructor", "Courses per Student"};
            int choice = JOptionPane.showOptionDialog(null, "Which report would you like to generate?", "Generate Report",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                String report = adminController.generateNumberOfStudentsPerInstructorReport();
                JOptionPane.showMessageDialog(MainUI.this, report, "Students per Instructor Report", JOptionPane.INFORMATION_MESSAGE);
            } else if (choice == 1) {
                String report = adminController.generateNumberOfAppliedCoursesPerStudentReport();
                JOptionPane.showMessageDialog(MainUI.this, report, "Courses per Student Report", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * A method to display the list of courses in a dialog window.
     */
    private void displayCourses() {
        StringBuilder coursesList = new StringBuilder("Courses:\n");
        for (Course course : adminController.getCourses()) {
            coursesList.append(course.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(MainUI.this, coursesList.toString());
    }

    /**
     * A method to display the list of students in a dialog window.
     */
    private void displayStudents() {
        StringBuilder studentsList = new StringBuilder("Students:\n");
        for (Student student : adminController.getStudents()) {
            studentsList.append(student.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(MainUI.this, studentsList.toString());
    }

    /**
     * A method to display the list of instructors in a dialog window.
     *
     * @return          description of return value
     */
    private void displayInstructors() {
        StringBuilder instructorsList = new StringBuilder("Instructors:\n");
        for (Instructor instructor : adminController.getInstructors()) {
            instructorsList.append(instructor.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(MainUI.this, instructorsList.toString());
    }

    /**
     * The main method of the program that initializes and displays the main user interface.
     *
     * @param  args  the command line arguments passed to the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainUI mainUI = new MainUI();
            mainUI.setVisible(true);
        });
    }
}
