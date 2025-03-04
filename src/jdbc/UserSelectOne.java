package jdbc;

import jdbc.users.User;
import lombok.Data;

import java.sql.*;
import java.util.Scanner;

@Data
public class UserSelectOne {
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

        String query1 = new StringBuilder()
                .append("SELECT * FROM users")
                .append(" WHERE userid = ?")
                .toString();
        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
        preparedStatement1.setString(1,"Hello");



        //4. SQL문 실행
        ResultSet rs = preparedStatement1.executeQuery();

        if(rs.next()){
            User user = new User();
            user.setUserid(rs.getString("userid"));
            user.setUsername(rs.getString("username"));
            user.setUserpassword(rs.getString("userpassword"));
            user.setUserage(rs.getInt("userage"));
            user.setUseremail(rs.getString("useremail"));
            System.out.println();
        }else System.out.println("가입된회원이아닙니다.");

        System.out.println("ID : " + rs.getString(1));
        System.out.println("name : " + rs.getString(2));
        System.out.println("password : " + rs.getString(3));
        System.out.println("age : " + rs.getString(4));
        System.out.println("email : " + rs.getString(5));

        System.out.println();


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
