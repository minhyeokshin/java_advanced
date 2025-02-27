package jdbc.board;

import java.sql.*;
import java.util.Scanner;

public class boardSelectAll {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection connection = null;
        ResultSet rs  = null;
        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok!" + connection);

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul","ssg","ssg1234");
            System.out.println("Connection OK" + connection);

            //3. 매개변수화된 SQL 문 작성


            String query = new StringBuilder()
                    .append(" SELECT * FROM boards ")
//                    .append(" WHERE bno = ? ")
                    .toString();


            PreparedStatement pstmt = connection.prepareStatement(query);
//            System.out.printf("검색할 글의 번호를 입력하세요 : ");
//            pstmt.setInt(1,in.nextInt());
//            in.nextLine();

            //4. SQL문 실행
            rs =  pstmt.executeQuery();


            while (rs.next()) {
                board board = new board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata").toString());
                System.out.println(board);
            }


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
