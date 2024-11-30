package courseregisterationproject;

import java.util.ArrayList;
import java.util.List;

public class RegistrationModel {

    public static class Student implements Observer {

        private String id;
        private String name;
        private List<Course> enrolledCourses = new ArrayList<>();

        public Student(String id, String name) {
            this.id = id;
            this.name = name;

        }

        public void enroll(Course course) {
            if (!enrolledCourses.contains(course)) { // Prevent duplicate entries
                enrolledCourses.add(course);
            }
        }

        public List<Course> getEnrolledCourses() {
            return enrolledCourses;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        @Override
        public void update(String message) {
            System.out.println("Notification to " + name + ": " + message);
        }

    }

    public static abstract class Course {

        protected String courseCode;
        protected String courseName;
        protected String instructor;
        protected int maxCapacity;
        protected List<Student> enrolledStudents = new ArrayList<>();
        private List<Observer> observers = new ArrayList<>();

        public Course(String courseCode, String courseName, String instructor, int maxCapacity) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.instructor = instructor;
            this.maxCapacity = maxCapacity;
        }

        public boolean hasCapacity() {
            return enrolledStudents.size() < maxCapacity;
        }

        public void addStudent(Student student) {
            if (!enrolledStudents.contains(student)) { // Prevent duplicate entries
                enrolledStudents.add(student);
                
                notifyObservers("Student " + student.getName() + " has enrolled in " + courseName + ". Current enrollment: " + enrolledStudents.size());
            }
            observers.add(student);
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getEnrolledStudentsCount() {
            return enrolledStudents.size();
        }

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        // Remove observer (student)
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        // Notify all observers with a custom message
        private void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

    }

    public static class LectureCourse extends Course {

        public LectureCourse(String courseCode, String courseName, String instructor, int maxCapacity) {
            super(courseCode, courseName, instructor, maxCapacity);
        }

    }

    public static class LabCourse extends Course {

        public LabCourse(String courseCode, String courseName, String instructor, int maxCapacity) {
            super(courseCode, courseName, instructor, maxCapacity);
        }
    }
}
