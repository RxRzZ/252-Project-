package courseregisterationproject;

public class ConsoleView {

    public void displayCourseDetails(RegistrationModel.Course course) {
        System.out.println("Course Code: " + course.getCourseCode());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Enrolled Students: " + course.getEnrolledStudentsCount());
    }

    public void displayStudentDetails(RegistrationModel.Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Enrolled Courses:");
        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("No enrolled courses.");
        } else {
            for (RegistrationModel.Course course : student.getEnrolledCourses()) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }

}
