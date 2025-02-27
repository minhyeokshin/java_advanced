package jdbc.boardver2;


import jdbc.boardver2.DBconnetion.DBConnetion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

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

            System.out.printf("제목 입력 : ");
            pstmt.setString(1, in.nextLine());
            System.out.printf("내용 입력 : ");
            pstmt.setString(2,in.nextLine());
            System.out.printf("작성자 입력 : ");
            pstmt.setString(3,in.nextLine());
            System.out.printf("이미지 파일 명 입력 : ");
            String image = in.nextLine();
            pstmt.setString(4,image);
            System.out.println("입력 예시 : src/jdbc/image");
            System.out.printf("이미지 경로 입력 : ");
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