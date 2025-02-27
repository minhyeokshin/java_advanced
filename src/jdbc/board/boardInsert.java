package jdbc.boards;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class boardInsert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok!" + connection);

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul","ssg","ssg1234");
            System.out.println("Connection OK" + connection);

            //3. 매개변수화된 SQL 문 작성

            String query = "" +
                    "INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) " +
                    "VALUES (?,?,?,now(),?,?); ";

            PreparedStatement pstmt = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);

            System.out.printf("제목 입력 : ");
            pstmt.setString(1, in.nextLine());
            System.out.printf("내용 입력 : ");
            pstmt.setString(2,in.nextLine());
            System.out.printf("작성자 입력 : ");
            pstmt.setString(3,in.nextLine());
            System.out.printf("이미지 파일 명 입력 : ");
            pstmt.setString(4,in.nextLine());
            System.out.printf("이미지 경로 입력 : ");
            pstmt.setBlob(5, new FileInputStream(in.nextLine()));


            //4. SQL문 실행
            int rows =  pstmt.executeUpdate();
            System.out.println(rows + " rows inserted");

            //bno 값 얻어오기
            if(rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    int bno = rs.getInt(1);
                    System.out.println(bno);
                }
                rs.close();

            }


            //5. PreparedStatement 객체 닫기
            pstmt.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
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