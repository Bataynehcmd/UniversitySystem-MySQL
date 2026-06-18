public class Student extends User {
    String major;
    public Student(int id ,String name ,String email ,String major) {
        super(id, name, email);
        this.major = major;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student ID: "+id+
                " Student Name: " +name+
                " Student Email: " +email+
                " Student Major: "+major);
    }
}
