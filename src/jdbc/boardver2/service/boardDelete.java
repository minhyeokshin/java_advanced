package jdbc.boardver2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.deleteboard;

public class boardDelete {

    private Connection connection;

    public boardDelete(Connection connection) {
        this.connection = connection;
    }

    public void delete() {
        Scanner in = new Scanner(System.in);

        try {

            //3. 매개변수화된 SQL 문 작성

             String query = new StringBuilder()
                    .append(" DELETE FROM boards ")
                    .append(" where bno = ?").toString();


            PreparedStatement pstmt = connection.prepareStatement(query);
            System.out.printf(deleteboard.getText());
            pstmt.setInt(1, in.nextInt());
            in.nextLine();

            //4. SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " rows delete completed");
            //5. PreparedStatement 객체 닫기
            pstmt.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

