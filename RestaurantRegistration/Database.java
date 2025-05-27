import java.sql.*;

public class Database {
    public static void saveUser(User user) {
        try {
            // Replace with your database info
            String url = "jdbc:mysql://localhost:3306/your_db_name";
            String userDB = "root";
            String passDB = "";

            Connection conn = DriverManager.getConnection(url, userDB, passDB);

            String query = "INSERT INTO users (username, phone, dob, email, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPhone());
            stmt.setString(3, user.getDob());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Registration failed.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

