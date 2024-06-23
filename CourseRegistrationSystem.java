import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    int enrolledStudents;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
    }

    boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }
}

class Student {
    static int lastId = 1000;
    String id;
    String name;
    List<Course> registeredCourses;

    Student(String name) {
        this.id = "S" + (++lastId);
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class CourseRegistrationSystem {
    static HashMap<String, Course> courseDatabase = new HashMap<>();
    static HashMap<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        addSampleData();

        while (true) {
            System.out.println("\n1. Display Courses");
            System.out.println("2. Add Student");
            System.out.println("3. Register for a course");
            System.out.println("4. Drop a course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    registerForCourse(scanner);
                    break;
                case 4:
                    dropCourse(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addSampleData() {
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basics of CS", 30, "Mon 9-11 AM");
        Course course2 = new Course("MATH101", "Calculus I", "Differential and Integral Calculus", 40, "Tue 10-12 AM");
        courseDatabase.put(course1.code, course1);
        courseDatabase.put(course2.code, course2);

        Student student1 = new Student("John Doe");
        Student student2 = new Student("Jane Smith");
        studentDatabase.put(student1.id, student1);
        studentDatabase.put(student2.id, student2);
    }

    static void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courseDatabase.values()) {
            System.out.printf("Code: %s, Title: %s, Capacity: %d, Enrolled: %d, Schedule: %s\n",
                    course.code, course.title, course.capacity, course.enrolledStudents, course.schedule);
        }
    }

    static void registerForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();
        Course course = courseDatabase.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (!course.hasAvailableSlots()) {
            System.out.println("Course is full.");
            return;
        }

        if (student.registeredCourses.contains(course)) {
            System.out.println("Already registered for this course.");
            return;
        }

        student.registeredCourses.add(course);
        course.enrolledStudents++;
        System.out.println("Successfully registered for the course.");
    }

    static void dropCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();
        Course course = courseDatabase.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (!student.registeredCourses.contains(course)) {
            System.out.println("Not registered for this course.");
            return;
        }

        student.registeredCourses.remove(course);
        course.enrolledStudents--;
        System.out.println("Successfully dropped the course.");
    }

    static void addStudent(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();
        Student newStudent = new Student(studentName);
        studentDatabase.put(newStudent.id, newStudent);
        System.out.println("Student added with ID: " + newStudent.id);
    }
}
