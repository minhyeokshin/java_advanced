package jdbc.boardver2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.*;

public class boardUpdate {
    private Connection connection;

    public boardUpdate (Connection connection) {
        this.connection = connection;
    }

    public void update() {
        Scanner in = new Scanner(System.in);

        try {

            //3. 매개변수화된 SQL 문 작성

            String query = new StringBuilder()
                    .append(" UPDATE boards SET ")
                    .append(" bcontent = ?")
                    .append(" where bno = ?").toString();


            PreparedStatement pstmt = connection.prepareStatement(query);
            System.out.printf(updatebno.getText());
            pstmt.setInt(2, in.nextInt());
            in.nextLine();
            System.out.printf(updatecontent.getText());
            pstmt.setString(1, in.nextLine());

            //4. SQL문 실행
            int rows =  pstmt.executeUpdate();
            System.out.println(rows + " rows update completed");
            //5. PreparedStatement 객체 닫기
            pstmt.close();

        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}