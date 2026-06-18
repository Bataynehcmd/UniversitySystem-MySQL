public class Admin extends User implements Loginable {

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
    @Override
    public void login() {
        System.out.println("Admin logged in");
    }

    @Override
    public void logout() {
        System.out.println("Admin logged out");
    }
}
