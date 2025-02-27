package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx2 {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(connection);

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?ServerTimeZone=Asia/Seoul", "ssg", "ssg1234");

            System.out.println("Connection OK!\t"+connection);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection close!" + connection);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
