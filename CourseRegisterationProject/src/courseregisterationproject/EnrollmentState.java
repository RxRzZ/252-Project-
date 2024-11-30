package courseregisterationproject;

public interface EnrollmentState {

    void handleRequest(RegistrationModel.Student student, RegistrationModel.Course course);
}
