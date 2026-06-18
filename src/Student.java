import java.util.ArrayList;

public class Student extends User implements Loginable {
    String major;
    ArrayList<Course> courses;
    public Student(int id ,String name ,String email ,String major) {
        super(id, name, email);
        this.major = major;
        courses = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: "+id+
                " Student Name: " +name+
                " Student Email: " +email+
                " Student Major: "+major);
    }
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    public void viewCourses() {
        if (courses.isEmpty()){
            System.out.println("No courses found");
        }
        else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
    public boolean removeCourse(int courseCode) {
         for (int i = 0; i < courses.size(); i++) {
             if (courses.get(i).getCourseCode() == courseCode) {
                 courses.remove(i);
                 return true;
             }
        }
        return false;
    }
    @Override
    public void login() {
        System.out.println("Student Login");
    }

    @Override
    public void logout() {
        System.out.println("Student Logout");
    }


}
