package courseregisterationproject;



public class CourseFactory {

    public static CourseProxy createCourse(String type, String code, String name, String instructor, int capacity) {
        RegistrationModel.Course course;

        switch (type.toLowerCase()) {
            case "lecture":
                course = new RegistrationModel.LectureCourse(code, name, instructor, capacity);
                break;
            case "lab":
                course = new RegistrationModel.LabCourse(code, name, instructor, capacity);
                break;
            default:
                throw new IllegalArgumentException("Unknown course type.");
        }
        return new CourseProxy(course);
    }

}
