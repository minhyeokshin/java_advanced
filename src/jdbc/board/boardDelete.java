package jdbc.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class boardDelete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok!" + connection);

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul","ssg","ssg1234");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssg?serverTimezone=Asia/Seoul", "root", "mysql1234");
            System.out.println("Connection OK" + connection);

            //3. 매개변수화된 SQL 문 작성

             String query = new StringBuilder()
                    .append(" DELETE FROM boards ")
                    .append(" where bno = ?").toString();


            PreparedStatement pstmt = connection.prepareStatement(query);
            System.out.printf("삭제할 게시판 번호 입력 : ");
            pstmt.setInt(1, in.nextInt());
            in.nextLine();

            //4. SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " rows delete completed");
            //5. PreparedStatement 객체 닫기
            pstmt.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

