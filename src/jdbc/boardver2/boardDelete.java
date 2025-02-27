package jdbc.boardver2;

import jdbc.boardver2.DBconnetion.DBConnetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class boardDelete {
    public void delete() {
        Scanner in = new Scanner(System.in);
        DBConnetion dbConnetion = new DBConnetion();
        Connection connection = DBConnetion.dbconnection();

        try {

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

        }catch (SQLException e) {
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

