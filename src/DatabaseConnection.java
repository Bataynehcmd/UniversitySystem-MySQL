import java.sql.*;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/university_system";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected Successfully!");
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public static void addUser(int id , String name , String mail ,String usertype) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, mail);
        ps.setString(4, usertype);
        ps.executeUpdate();
        System.out.println("Inserted Successfully!");
        ps.close();
        conn.close();
    }
    public static void viewUsers() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name")
            + " " + rs.getString("mail")
                    + " " + rs.getString("usertype")
            );
        }
        rs.close();
        ps.close();
        conn.close();
    }
    public static void searchUser(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users " +
                "WHERE id = ?");

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt("id") == id) {
                System.out.println(rs.getString("name")
                + " " + rs.getString("mail")
                + " " + rs.getString("usertype"));
                System.out.println("\n");
            }
            else {
                System.out.println("Not Found");
            }
        }
        rs.close();
        ps.close();
        conn.close();
    }
    public static void deleteUser(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id = ?");
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Deleted Successfully!");
        }
        else {
            System.out.println("Not Found");
        }
        ps.close();
        conn.close();
    }
    public static void updateUser(int id , String name , String mail ,String usertype) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE users SET name = ?, mail = ?,usertype = ? WHERE id = ?");
        ps.setString(1, name);
        ps.setString(2, mail);
        ps.setString(3, usertype);
        ps.setInt(4, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Updated Successfully!");
        }
        else {
            System.out.println("Not Found");
        }
        ps.close();
        conn.close();
    }
    public static void addCoursetoStudent(int id,int courseId) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO student_courses VALUES(?,?)");
        ps.setInt(1, id);
        ps.setInt(2, courseId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Inserted Successfully!");
        }
        ps.close();
        conn.close();
    }
    public static void viewCoursetoStudent(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT c.course_code, c.course_name" +
                " FROM courses c " +
                " JOIN student_courses sc " +
                " ON c.course_code =sc.course_code" +
                " WHERE sc.student_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println(rs.getString("course_code")+
                    " "+rs.getString("course_name"));
        }
        if (!found) {
            System.out.println("Not Found");
        }
        rs.close();
        ps.close();
        conn.close();
    }
    public static void deleteCoursetoStudent(int id,int courseID) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM student_courses " +
                "WHERE student_id = ?"+"" +
                " AND course_code = ?");
        ps.setInt(1, id);
        ps.setInt(2, courseID);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Deleted Successfully!");
        }
        else{
            System.out.println("Not Found");
        }
        ps.close();
        conn.close();
    }
}
