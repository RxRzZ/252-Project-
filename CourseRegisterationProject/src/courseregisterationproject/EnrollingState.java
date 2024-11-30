package courseregisterationproject;

public class EnrollingState implements EnrollmentState {

    @Override
    public void handleRequest(RegistrationModel.Student student, RegistrationModel.Course course) {
        System.out.println(student.getName() + " has enrolled " + course.getCourseName());
    }

}
