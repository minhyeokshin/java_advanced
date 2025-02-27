package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ConnectionEx {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner in = new Scanner(System.in);

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

//        System.out.printf("ID 입력 : ");
//        preparedStatement.setString(1,in.nextLine());
//        System.out.printf("이름 입력 : ");
//        preparedStatement.setString(2,in.nextLine());
//        System.out.printf("PW 입력 : ");
//        preparedStatement.setString(3,in.nextLine());
//        System.out.printf("나이 입력 : ");
//        preparedStatement.setInt(4,in.nextInt());
//        in.nextLine();
//        System.out.printf("email 입력 : ");
//        preparedStatement.setString(5,in.nextLine());



        //4. SQL문 실행
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows+"개의 user데이터가 입력되었습니다.");


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
