package courseregisterationproject;

public class EnrolledState implements EnrollmentState {

    @Override
    public void handleRequest(RegistrationModel.Student student, RegistrationModel.Course course) {
        System.out.println(student.getName() + " is already enrolled in " + course.getCourseName());
    }

}
