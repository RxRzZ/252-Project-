package courseregisterationproject;

public class WaitlistedState implements EnrollmentState {

    @Override
    public void handleRequest(RegistrationModel.Student student, RegistrationModel.Course course) {
        System.out.println(student.getName() + " is on the waitlist for " + course.getCourseName() + " because it is full.");
    }

}
