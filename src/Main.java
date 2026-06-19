import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("\nWelcome to University System\n");
            System.out.println("Select A Choice:\n");
            System.out.println("1.Add A User");
            System.out.println("2.View All Users");
            System.out.println("3.Serach User");
            System.out.println("4.Delete User");
            System.out.println("5.Update User");
            System.out.println("6.Add Course To Student");
            System.out.println("7.View Student Courses");
            System.out.println("8.Delete Student Cousrses");
            System.out.println("9.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addUser(sc);
                    break;
                case 2:
                    DatabaseConnection.viewUsers();
                    break;
                case 3:
                    serachUser(sc);
                    break;
                case 4:
                    deleteUser(sc);
                    break;
                case 5:
                    updateUser(sc);
                    break;
                case 6:
                    addCoursetoStudent(sc);
                    break;
                case 7:
                    viewCoursetoStudent(sc);
                    break;
                case 8:
                    deleteCoursetoStudent(sc);
                    break;
                case 9:
                    return;

            }
        }
    }

    public static void addUser(Scanner in) throws SQLException {
        System.out.println("Select User Type: ");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.println("3. Admin");
        int id = in.nextInt();
        switch (id) {
            case 1:
                System.out.println("Enter Student ID: ");
                int idUser = in.nextInt();
                System.out.println("Enter Student Name: ");
                String name = in.next();
                System.out.println("Enter Student Mail: ");
                String mail = in.next();
                DatabaseConnection.addUser(idUser, name, mail, "Student");
                System.out.println("Student Added Successfully");
                break;
            case 2:
                System.out.println("Enter Teacher ID: ");
                idUser = in.nextInt();
                System.out.println("Enter Teacher Name: ");
                name = in.next();
                System.out.println("Enter Teacher Mail: ");
                mail = in.next();
                DatabaseConnection.addUser(idUser, name, mail, "Teacher");
                System.out.println("Teacher Added Successfully");
                break;
            case 3:
                System.out.println("Enter Admin ID: ");
                idUser = in.nextInt();
                System.out.println("Enter Admin Name: ");
                name = in.next();
                System.out.println("Enter Admin Mail: ");
                mail = in.next();
                DatabaseConnection.addUser(idUser, name, mail, "Admin");
                System.out.println("Admin Added Successfully");
                break;
        }
    }

    public static void serachUser(Scanner in) throws SQLException {
        System.out.println("Search User\n");
        System.out.println("Enter User ID: ");
        int id = in.nextInt();
        DatabaseConnection.searchUser(id);
    }

    public static void deleteUser(Scanner in) throws SQLException {
        System.out.println("Delete User\n");
        System.out.println("Enter User ID: ");
        int id = in.nextInt();
        DatabaseConnection.deleteUser(id);
    }

    public static void updateUser(Scanner in) throws SQLException {
        System.out.println("Update User\n");
        System.out.println("Enter User ID: ");
        int id = in.nextInt();
        System.out.println("Enter User Name: ");
        String name = in.next();
        System.out.println("Enter User Mail: ");
        String mail = in.next();
        System.out.println("Enter User Datatype");
        String datatype = in.next();
        DatabaseConnection.updateUser(id, name, mail, datatype);

    }

    public static void addCoursetoStudent(Scanner in) throws SQLException {
        System.out.println("Add Course To Student\n");
        System.out.println("Enter Student ID: ");
        int id = in.nextInt();
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        DatabaseConnection.addCoursetoStudent(id, courseId);
    }

    public static void viewCoursetoStudent(Scanner in) throws SQLException {
        System.out.println("Search Course To Student\n");
        System.out.println("Enter Student ID: ");
        int id = in.nextInt();
        DatabaseConnection.viewCoursetoStudent(id);
    }

    public static void deleteCoursetoStudent(Scanner in) throws SQLException {
        System.out.println("Delete Student Cousrses\n");
        System.out.println("Enter Student ID: ");
        int id = in.nextInt();
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        DatabaseConnection.deleteCoursetoStudent(id, courseId);
    }
}

