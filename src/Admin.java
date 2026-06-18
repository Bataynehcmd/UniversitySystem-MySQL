public class Admin extends User {

    String role;
    public Admin(int id ,String name ,String email ,String role) {
        super(id, name, email);
        this.role = role;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student ID: "+id+
                " Student Name: " +name+
                " Student Email: " +email+
                " Student role: "+role);
    }
}
