package courseregisterationproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Setup students
        List<RegistrationModel.Student> students = new ArrayList<>();
        students.add(new RegistrationModel.Student("S001", "Ahmad Mohammed"));
        students.add(new RegistrationModel.Student("S002", "Ali Hassan"));
        students.add(new RegistrationModel.Student("S003", "Omar Khaled"));
        students.add(new RegistrationModel.Student("S004", "Fahad Abdullah"));
        students.add(new RegistrationModel.Student("S005", "Yousef Ibrahim"));
        students.add(new RegistrationModel.Student("S006", "Khalid Yasin"));
        students.add(new RegistrationModel.Student("S007", "Hassan Mahmoud"));
        students.add(new RegistrationModel.Student("S008", "Saad Faris"));
        students.add(new RegistrationModel.Student("S009", "Abdullah Nasser"));
        students.add(new RegistrationModel.Student("S010", "Rami Saeed"));

        // Create CourseProxsies using the CourseFactory
        CourseProxy course1 = CourseFactory.createCourse("lecture", "CPIT250", "System Analysis & Design", "Dr. Ahmed", 30);
        CourseProxy course2 = CourseFactory.createCourse("lecture", "CPIT251", "Software Engineering 1", "Dr. Mohammed", 25);
        CourseProxy course3 = CourseFactory.createCourse("lecture", "CPIT252", "Software Design Patterns", "Dr. Rizwan", 20);
        CourseProxy course4 = CourseFactory.createCourse("lecture", "CPIT240", "Database 1", "Dr. Mutasem", 30);
        CourseProxy course5 = CourseFactory.createCourse("lecture", "CPIT370", "Computer Networks", "Dr. Adil", 15);

        // Create two lab courseproxies
        CourseProxy labCourse1 = CourseFactory.createCourse("lab", "CPIT252L", "Software Design Patterns Lab", "Dr. Rizwan", 15);
        CourseProxy labCourse2 = CourseFactory.createCourse("lab", "CPIT370L", "Computer Networks Lab", "Dr. Adil", 10);

        // Create list of Course Proxies
        List<CourseProxy> courseProxies = List.of(course1, course2, course3, course4, course5, labCourse1, labCourse2);

        // MVC Setup
        ConsoleView view = new ConsoleView();
        RegisterationController controller = new RegisterationController(view);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- University Registration System ---");
                    
            System.out.println("1. Enroll in a Course");
            System.out.println("2. View Student Details");
            System.out.println("3. View Course Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Select a student
                    System.out.println("Select a student:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName() + " (" + students.get(i).getId() + ")");
                    }
                    System.out.print("Enter student number: ");
                    int studentIndex = scanner.nextInt() - 1;

                    if (studentIndex < 0 || studentIndex >= students.size()) {
                        System.out.println("Invalid student selection.");
                        break;
                    }
                    RegistrationModel.Student selectedStudent = students.get(studentIndex);

                    // Select a course
                    System.out.println("Available courses:");
                    for (int i = 0; i < courseProxies.size(); i++) {
                        System.out.println((i + 1) + ". " + courseProxies.get(i).getCourseName() + " (" + courseProxies.get(i).getCourseCode() + ")");
                    }
                    System.out.print("Enter course number: ");
                    int courseIndex = scanner.nextInt() - 1;

                    if (courseIndex < 0 || courseIndex >= courseProxies.size()) {
                        System.out.println("Invalid course selection.");
                        break;
                    }
                    CourseProxy selectedCourseProxy = courseProxies.get(courseIndex);

                    // Enroll student via the proxy
                    selectedCourseProxy.enrollStudent(selectedStudent);

                    break;

                case 2:
                    // View student details
                    System.out.println("Select a student:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName() + " (" + students.get(i).getId() + ")");
                    }
                    System.out.print("Enter student number: ");
                    studentIndex = scanner.nextInt() - 1;

                    if (studentIndex >= 0 && studentIndex < students.size()) {
                        RegistrationModel.Student student = students.get(studentIndex);
                        controller.showStudentDetails(student);
                    } else {
                        System.out.println("Invalid student selection.");
                    }
                    break;

                case 3:
                    // View course details
                    System.out.println("Available courses:");
                    for (int i = 0; i < courseProxies.size(); i++) {
                        System.out.println((i + 1) + ". " + courseProxies.get(i).getCourseName() + " (" + courseProxies.get(i).getCourseCode() + ")");
                    }
                    System.out.print("Enter course number to view details: ");
                    courseIndex = scanner.nextInt() - 1;

                    if (courseIndex >= 0 && courseIndex < courseProxies.size()) {
                        CourseProxy courseProxy = courseProxies.get(courseIndex);
                        controller.showCourseDetails(courseProxy.getCourse());
                    } else {
                        System.out.println("Invalid course selection.");
                    }
                    break;

                case 4:
                    // Exit the system
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
