package courseregisterationproject;

public class CourseProxy {

    private RegistrationModel.Course course;
    private EnrollmentContext enrollmentContext;

    public CourseProxy(RegistrationModel.Course course) {
        this.course = course;
        this.enrollmentContext = new EnrollmentContext();
    }

    public void enrollStudent(RegistrationModel.Student student) {
        // Determine the state for enrollment
        if (student.getEnrolledCourses().contains(course)) {
            enrollmentContext.setState(new EnrolledState()); // Already enrolled
        } else if (!course.hasCapacity()) {
            enrollmentContext.setState(new WaitlistedState()); // Go to waiting list, because section is full
        } else {
            course.addStudent(student);
            student.enroll(course);
            enrollmentContext.setState(new EnrollingState());  // Enroll in course
        }

        // Delegate to EnrollmentContext to handle the state-specific behavior
        enrollmentContext.requestEnrollment(student, course);
    }

    public String getCourseName() {
        return course.getCourseName();
    }

    public String getCourseCode() {
        return course.getCourseCode();
    }

    public int getEnrolledStudentsCount() {
        return course.getEnrolledStudentsCount();
    }

    public RegistrationModel.Course getCourse() {
        return course;
    }

   
}
