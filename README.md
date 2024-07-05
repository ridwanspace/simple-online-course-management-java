
# Online Course Management System

This is a simple Java-based application for managing online courses, students, and instructors. The application allows administrators to add instructors, courses, and students, and to assign students to courses. It also provides reports on the number of students per instructor and the number of applied courses per student.

## Features

- **Admin Login:** Bypasses username and password input for demonstration purposes.
- **Input Data:**
  - Add Instructor and Course
  - Add Course
  - Add Student
- **Process:**
  - Apply a Student to a Course
- **Reports:**
  - Number of Students per Instructor
  - Number of Applied Courses per Student

## Requirements

- Java Development Kit (JDK) 8 or higher
- A Java IDE or a text editor with Java support

## Project Structure

```plaintext
online-course-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── OnlineCourseManagementSystem.java
│   │   │   │   │   ├── DataInitializer.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   ├── AdminController.java
│   │   │   │   │   │   ├── InstructorController.java
│   │   │   │   │   │   ├── StudentController.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── Course.java
│   │   │   │   │   │   ├── Student.java
│   │   │   │   │   │   ├── Instructor.java
│   │   │   │   │   │   ├── Assignment.java
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── MainUI.java
README.md
```

## Setup and Run

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/ridwanspace/simple-online-course-management-java.git
   cd simple-online-course-management-java
   ```

2. **Compile the Code:**
   ```sh
   javac -d bin src/main/java/com/example/**/*.java
   ```

3. **Run the Application:**
   ```sh
   java -cp bin com.example.ui.MainUI
   ```

## Usage

### Admin Login and Data Input

1. **Admin Login:**
   - Click on the "Admin Login" button.
   - You will be prompted to choose what data to input: Instructor, Course, or Student.

2. **Add Instructor and Course:**
   - Enter the instructor's name and the course name.

3. **Add Course:**
   - Enter the course name.

4. **Add Student:**
   - Enter the student's name.

### Apply Course

1. **Apply Course:**
   - Click on the "Apply Course" button.
   - Select a student from the dropdown list.
   - Select a course (displayed as "Instructor Name - Course Name") from the dropdown list.

### Generate Reports

1. **Generate Reports:**
   - Click on the "Generate Reports" button.
   - Choose the type of report you want to generate: Students per Instructor or Courses per Student.

## Classes Overview

### `com.example.OnlineCourseManagementSystem`
- Main class to initialize and run the application.

### `com.example.DataInitializer`
- Initializes the application with dummy data for demonstration purposes.

### `com.example.controller.AdminController`
- Manages the core functionalities such as creating courses, registering students, applying students to courses, and generating reports.

### `com.example.controller.InstructorController`
- Manages instructor-specific functionalities (currently minimal for this demo).

### `com.example.controller.StudentController`
- Manages student-specific functionalities (currently minimal for this demo).

### `com.example.model.Course`
- Represents a course with attributes such as name, instructor, students, and assignments.

### `com.example.model.Student`
- Represents a student with attributes such as name.

### `com.example.model.Instructor`
- Represents an instructor with attributes such as name.

### `com.example.model.Assignment`
- Represents an assignment with attributes such as name and grade.

### `com.example.ui.MainUI`
- Manages the user interface, including buttons for admin login, viewing data, applying courses, and generating reports.

## Dummy Data Initialization

The `DataInitializer` class initializes the application with the following dummy data:
- 5 Instructors: Dr. Smith, Dr. Johnson, Dr. Brown, Dr. Miller, Dr. Davis
- 5 Courses: Math 101, Physics 101, Chemistry 101, Biology 101, History 101
- 5 Students: John Doe, Jane Doe, Alice Smith, Bob Johnson, Charlie Brown

## License

This project is licensed under the MIT License.

## Acknowledgements

- Developed with the help of Java Swing for the GUI.
- Inspired by common use cases in course management systems.
