import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();

        while (true) {

            System.out.println("\nWelcome to University System\n");
            System.out.println("Select A Choice:\n");
            System.out.println("1.Add A User");
            System.out.println("2.View All Users");
            System.out.println("3.Serach User");
            System.out.println("4.Delete User");
            System.out.println("5.Update User");
            System.out.println("6.Exit");
            int choice = sc.nextInt();
            boolean found = false;
            switch (choice) {
                case 1:
                    System.out.println("Select User Type: ");
                    System.out.println("1. Student");
                    System.out.println("2. Teacher");
                    System.out.println("3. Admin");
                    User newUser = null;
                    int userType = sc.nextInt();
                    switch (userType) {
                        case 1:
                            System.out.println("Enter Student ID: ");
                            int studentId = sc.nextInt();
                            if (idExists(users, studentId)) {
                                System.out.println("ID is already in use.");
                                break;
                            }
                                System.out.println("Enter Student Name: ");
                                String studentName = sc.next();
                                System.out.println("Enter Student Email: ");
                                String studentEmail = sc.next();
                                System.out.println("Enter Student Major: ");
                                String studentMajor = sc.next();
                                newUser = new Student(studentId, studentName, studentEmail, studentMajor);
                                users.add(newUser);
                                break;

                        case 2:
                            System.out.println("Enter Teacher ID: ");
                            int teacherId = sc.nextInt();
                            if (idExists(users, teacherId)) {
                                System.out.println("ID is already in use.");
                                break;
                            }
                            System.out.println("Enter Teacher Name: ");
                            String teacherName = sc.next();
                            System.out.println("Enter Teacher Email: ");
                            String teacherEmail = sc.next();
                            System.out.println("Enter Teacher Department: ");
                            String teacherDepartment = sc.next();
                            newUser = new Teacher(teacherId, teacherName, teacherEmail, teacherDepartment);
                            users.add(newUser);
                            break;
                        case 3:
                            System.out.println("Enter Admin ID: ");
                            int adminId = sc.nextInt();
                            if (idExists(users, adminId)) {
                                System.out.println("ID is already in use.");
                                break;
                            }
                            System.out.println("Enter Admin Name: ");
                            String adminName = sc.next();
                            System.out.println("Enter Admin Email: ");
                            String adminEmail = sc.next();
                            System.out.println("Enter Admin Role: ");
                            String adminRole = sc.next();
                            newUser = new Admin(adminId, adminName, adminEmail, adminRole);
                            users.add(newUser);
                            break;
                    }
                    break;

                case 2:
                    for (User user : users) {
                        user.displayInfo();
                    }
                    break;

                case 3:

                    System.out.println("Search User\n");
                    System.out.println("Enter User ID: ");
                    int userId = sc.nextInt();
                    for (User user : users) {
                        if (user.getId() == userId) {
                            user.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found\n");
                    }
                    break;

                case 4:

                    System.out.println("Delete User\n");
                    System.out.println("Enter User ID: ");
                    int deleteId = sc.nextInt();
                    for (int i = 0; i < users.size(); i++) {

                        if (users.get(i).getId() == deleteId) {
                            users.remove(i);
                            System.out.println("User Deleted Successfully");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found\n");
                    }
                    break;
                case 5:
                    System.out.println("Update User\n");
                    System.out.println("Enter User ID: ");
                    int updateId = sc.nextInt();
                    for (int i = 0; i < users.size(); i++) {

                        if (users.get(i).getId() == updateId) {
                            found = true;
                            System.out.println("Enter User Name: ");
                            String updateName = sc.next();
                            System.out.println("Enter User Email: ");
                            String updateEmail = sc.next();
                            users.get(i).setName(updateName);
                            users.get(i).setEmail(updateEmail);
                            System.out.println("User Updated Successfully");
                            break;
                        }

                    }
                    if(!found) {
                        System.out.println("User not found\n");
                    }
                    break;

                case 6:
                    return;

            }
        }
    }

    public static boolean idExists(ArrayList<User> users, int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return true;

            }
        }
        return false;
    }

}

