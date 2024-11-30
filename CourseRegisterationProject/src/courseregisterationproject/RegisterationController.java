package courseregisterationproject;

public class RegisterationController {

    private ConsoleView view;

    public RegisterationController(ConsoleView view) {
        this.view = view;
    }

    // Display student details using the view
    public void showStudentDetails(RegistrationModel.Student student) {
        view.displayStudentDetails(student);
    }

    // Display course details using the view
    public void showCourseDetails(RegistrationModel.Course course) {
        view.displayCourseDetails(course);
    }

}
