package jdbc.boardver2.service;

import jdbc.board.board;

import java.sql.*;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.*;

public class boardSelect {

    private Connection connection;

    public boardSelect(Connection connection) {
        this.connection = connection;
    }

    public void select() {
        Scanner in = new Scanner(System.in);

        int choice = 0;
        ResultSet rs  = null;
        try {

            //3. 매개변수화된 SQL 문 작성
            System.out.println(selectchoice.getText());
            System.out.printf(selectinput.getText());
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
                    System.out.printf(selectbno.getText());
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
                        board.setBfiledata(rs.getBlob("bfiledata").getBinaryStream().toString());
                        System.out.println(board);


                    } else {

                        System.out.println(selecterror.getText());
                    }
                    pstmt2.close();
                    break;
                default:
                    System.out.println(choiceerror.getText());
                    break;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
