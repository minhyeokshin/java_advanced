package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionEx3 {

    public void Insert(String userid1,String username1,String userpassword1,int userage1,String useremail1) throws SQLException, ClassNotFoundException {


            Connection connection = null;

            //1. JDBC 드라이버 등록 : MySQL DB 접근하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok!" + connection);

            //2. MySQL DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul","ssg","ssg1234");

            System.out.println("Connection OK!"+connection);

            //3. 매개변수화된 SQL 문 작성

            String query = "" + "INSERT INTO users (userid,username,userpassword,userage,useremail)" +
                    "VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,userid1);
            preparedStatement.setString(2,username1);
            preparedStatement.setString(3,userpassword1);
            preparedStatement.setInt(4,userage1);
            preparedStatement.setString(5,useremail1);

            //4. SQL문 실행
            int rows = preparedStatement.executeUpdate();


            System.out.println(preparedStatement);

            if(connection != null) {
                try {
                    connection.close();
                    System.out.println("connection closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

