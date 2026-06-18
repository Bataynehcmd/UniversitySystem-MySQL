public class Teacher extends User {

    String department;

    public Teacher(int id ,String name ,String email ,String department) {
        super(id, name, email);
        this.department = department;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student ID: "+id+
                " Student Name: " +name+
                " Student Email: " +email+
                " Student department: "+department);
    }
}
