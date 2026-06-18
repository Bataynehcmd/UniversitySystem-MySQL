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
            System.out.println("6. Add Course To Student");
            System.out.println("7. View Student Courses");
            System.out.println("8.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addUser(users, sc);
                    break;
                case 2:
                    viewAllUsers(users);
                    break;
                case 3:
                    serachUser(users, sc);
                    break;
                case 4:
                    deleteUser(users, sc);
                    break;
                case 5:
                    updateUser(users, sc);
                    break;
                case 6:
                    addCoursetoStudent(users, sc);
                    break;
                case 7:
                    viewStudentCousrses(users, sc);
                    break;
                case 8:
                    deleteStudentCousrses(users, sc);
                    break;
                case 9:
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

    public static void addUser(ArrayList<User> users, Scanner in) {
        User newUser = null;
        System.out.println("Select User Type: ");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.println("3. Admin");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter User ID: ");
                int studentId = in.nextInt();
                if (idExists(users, studentId)) {
                    System.out.println("ID is already in use.");
                    break;
                }
                System.out.println("Enter Student Name: ");
                String studentName = in.next();
                System.out.println("Enter Student Email: ");
                String studentEmail = in.next();
                System.out.println("Enter Student Major: ");
                String studentMajor = in.next();
                newUser = new Student(studentId, studentName, studentEmail, studentMajor);
                users.add(newUser);
                System.out.println("User Added Successfully!");
                break;
            case 2:
                System.out.println("Enter Teacher ID: ");
                int teacherId = in.nextInt();
                if (idExists(users, teacherId)) {
                    System.out.println("ID is already in use.");
                    break;
                }
                System.out.println("Enter Teacher Name: ");
                String teacherName = in.next();
                System.out.println("Enter Teacher Email: ");
                String teacherEmail = in.next();
                System.out.println("Enter Teacher Department: ");
                String teacherDepartment = in.next();
                newUser = new Teacher(teacherId, teacherName, teacherEmail, teacherDepartment);
                users.add(newUser);
                System.out.println("User Added Successfully!");
                break;
            case 3:
                System.out.println("Enter Admin ID: ");
                int adminId = in.nextInt();
                if (idExists(users, adminId)) {
                    System.out.println("ID is already in use.");
                    break;
                }
                System.out.println("Enter Admin Name: ");
                String adminName = in.next();
                System.out.println("Enter Admin Email: ");
                String adminEmail = in.next();
                System.out.println("Enter Admin Role: ");
                String adminRole = in.next();
                newUser = new Admin(adminId, adminName, adminEmail, adminRole);
                users.add(newUser);
                System.out.println("User Added Successfully!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public static void viewAllUsers(ArrayList<User> users) {
        for (User user : users) {
            user.displayInfo();
        }
    }

    public static void serachUser(ArrayList<User> users, Scanner in) {
        boolean found = false;
        System.out.println("Search User\n");
        System.out.println("Enter User ID: ");
        int userId = in.nextInt();
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
    }

    public static void deleteUser(ArrayList<User> users, Scanner in) {
        boolean found = false;
        System.out.println("Delete User\n");
        System.out.println("Enter User ID: ");
        int deleteId = in.nextInt();
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
    }

    public static void updateUser(ArrayList<User> users, Scanner in) {
        boolean found = false;

        System.out.println("Update User\n");
        System.out.println("Enter User ID: ");
        int updateId = in.nextInt();
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == updateId) {
                found = true;
                System.out.println("Enter User Name: ");
                String updateName = in.next();
                System.out.println("Enter User Email: ");
                String updateEmail = in.next();
                users.get(i).setName(updateName);
                users.get(i).setEmail(updateEmail);
                System.out.println("User Updated Successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("User not found\n");
        }
    }

    public static void addCoursetoStudent(ArrayList<User> users, Scanner in) {
        boolean found = false;
        System.out.println("Add Course To Student\n");
        System.out.println("Enter User ID: ");
        int userId = in.nextInt();
        for (User user : users) {
            if (user.getId() == userId) {
                if (user instanceof Student) {
                    found = true;
                    Student student = (Student) user;
                    System.out.println("Enter Course Name: ");
                    String courseName = in.next();
                    System.out.println("Enter Course Code ");
                    int courseCode = in.nextInt();
                    Course course = new Course(courseName, courseCode);
                    student.addCourse(course);
                    System.out.println("Course Added Successfully");
                    break;
                } else {
                    System.out.println("This user is not a student\n");
                }
            }
        }
        if (!found) {
            System.out.println("User not found or not a student");
        }
    }

    public static void viewStudentCousrses(ArrayList<User> users, Scanner in) {
        boolean found = false;
        System.out.println("View Student Course\n");
        System.out.println("Enter User ID: ");
        int usedrId = in.nextInt();
        for (User user : users) {
            if (user.getId() == usedrId) {
                if (user instanceof Student) {
                    Student student = (Student) user;
                    student.viewCourses();
                    found = true;
                    break;
                } else {
                    System.out.println("This user is not a student");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("User not found\n");
        }

    }

    public static void deleteStudentCousrses(ArrayList<User> users, Scanner in) {
        boolean found = false;
        System.out.println("Delete Student Course\n");
        System.out.println("Enter User ID: ");
        int usedrId = in.nextInt();
        for (User user : users) {
            if (user.getId() == usedrId) {
                if (user instanceof Student) {
                    Student student = (Student) user;
                    student.viewCourses();
                    found = true;
                    System.out.println("Enter Course Code: ");
                    int courseCode = in.nextInt();
                    boolean removed = student.removeCourse(courseCode);
                    if (removed) {
                        System.out.println("Course Removed Successfully");
                        break;
                    } else {
                        System.out.println("Course not found");
                    }
                } else {
                    System.out.println("This user is not a student\n");
                }
            }
        }
        if (!found) {
            System.out.println("User not found\n");
        }
    }
}

