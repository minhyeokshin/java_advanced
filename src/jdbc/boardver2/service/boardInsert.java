package jdbc.boardver2.service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.*;

public class boardInsert {

    private Connection connection;

    public boardInsert(Connection connection) {
        this.connection = connection;
    }
    public void insert() {
        Scanner in = new Scanner(System.in);

        try {
            //3. 매개변수화된 SQL 문 작성
            String query = "" +
                    "INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) " +
                    "VALUES (?,?,?,now(),?,?); ";

            PreparedStatement pstmt = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);

            System.out.printf(inserttile.getText());
            pstmt.setString(1, in.nextLine());
            System.out.printf(insertcontent.getText());
            pstmt.setString(2,in.nextLine());
            System.out.printf(insertwriter.getText());
            pstmt.setString(3,in.nextLine());
            System.out.printf(insertfilename.getText());
            String image = in.nextLine();
            pstmt.setString(4,image);
            System.out.println(insertfileinputex.getText());
            System.out.printf(insertfileinput.getText());
            pstmt.setBlob(5,new FileInputStream(in.nextLine()+"/"+image));


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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}