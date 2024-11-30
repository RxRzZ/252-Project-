package courseregisterationproject;

public class EnrollmentContext {

    private EnrollmentState currentState;

    public void setState(EnrollmentState state) {
        this.currentState = state;
    }

    public void requestEnrollment(RegistrationModel.Student student, RegistrationModel.Course course) {
        currentState.handleRequest(student, course);
    }

}
