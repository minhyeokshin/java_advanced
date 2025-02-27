package jdbc.boardver2.dbconnetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.*;

public class DBConnetion {

    public static Connection dbconnection() {
        String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul";
        String id;
        String pw;

        System.out.println(runboard.getText());
        System.out.println(login.getText());
        Scanner in = new Scanner(System.in);
        System.out.printf(inputid.getText());
        id = in.nextLine();
        System.out.printf(inputpw.getText());
        pw = in.nextLine();

        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection(URL, id, pw);
            System.out.println("Connection OK" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(loginerror.getText());
            System.out.println(systemexit.getText());
            System.exit(0);
        }
        return connection;
    }

    public static Connection userchange() {
        String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul";
        String id;
        String pw;

        System.out.println(changelogin.getText());
        System.out.println(login.getText());
        Scanner in = new Scanner(System.in);
        System.out.printf(inputid.getText());
        id = in.nextLine();
        System.out.printf(inputpw.getText());
        pw = in.nextLine();

        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection(URL, id, pw);
            System.out.println("Connection OK" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(loginerror.getText());
            System.out.println(systemexit.getText());
            System.exit(0);
        }
        return connection;
    }

}
