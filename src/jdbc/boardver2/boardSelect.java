package jdbc.boardver2;

import jdbc.board.board;
import jdbc.boardver2.DBconnetion.DBConnetion;

import java.sql.*;
import java.util.Scanner;

public class boardSelect {

    public void select() {
        Scanner in = new Scanner(System.in);
        DBConnetion dbConnetion = new DBConnetion();
        Connection connection = DBConnetion.dbconnection();
        int choice = 0;
        ResultSet rs  = null;
        try {

            //3. 매개변수화된 SQL 문 작성
                        System.out.println("1. 전체 검색\t2.선택 검색");
            System.out.printf("입력 : ");
            choice = in.nextInt();
            in.nextLine();
            switch (choice){
                case 1:
                    String query1 = new StringBuilder()
                            .append(" SELECT * FROM boards ")
                            .toString();

                    PreparedStatement pstmt = connection.prepareStatement(query1);

                    //4. SQL문 실행
                    rs =  pstmt.executeQuery();


                    while (rs.next()) {
                        jdbc.board.board board = new board();
                        board.setBno(rs.getInt("bno"));
                        board.setBtitle(rs.getString("btitle"));
                        board.setBcontent(rs.getString("bcontent"));
                        board.setBwriter(rs.getString("bwriter"));
                        board.setBdate(rs.getDate("bdate"));
                        board.setBfilename(rs.getString("bfilename"));
                        board.setBfiledata(rs.getBlob("bfiledata").toString());
                        System.out.println(board);
                    }
                    pstmt.close();
                    break;
                case 2:
                    String query2 = new StringBuilder()
                            .append(" SELECT * FROM boards ")
                            .append(" WHERE bno = ? ")
                            .toString();


                    PreparedStatement pstmt2 = connection.prepareStatement(query2);
                    System.out.printf("검색할 글의 번호를 입력하세요 : ");
                    pstmt2.setInt(1,in.nextInt());
                    in.nextLine();

                    //4. SQL문 실행
                    rs =  pstmt2.executeQuery();

                    if(rs.next()) {
                        jdbc.board.board board = new board();
                        board.setBno(rs.getInt("bno"));
                        board.setBtitle(rs.getString("btitle"));
                        board.setBcontent(rs.getString("bcontent"));
                        board.setBwriter(rs.getString("bwriter"));
                        board.setBdate(rs.getDate("bdate"));
                        board.setBfilename(rs.getString("bfilename"));
                        board.setBfiledata(rs.getBlob("bfiledata").toString());
                        System.out.println(board);


                    } else {

                        System.out.println("없는 글입니다.");
                    }
                    pstmt2.close();
                    break;
                default:
                    System.out.println("선택 오류 프로그램을 종료합니다.");
                    break;
            }

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
