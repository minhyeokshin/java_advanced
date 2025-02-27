package jdbc.boardver2.DBconnetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnetion {

    public static Connection dbconnection() {
        String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul";
        String id;
        String pw;

        System.out.println("게시판 프로그램을 실행합니다.");
        System.out.println("로그인을 합니다.");
        Scanner in = new Scanner(System.in);
        System.out.printf("id 입력 : ");
        id = in.nextLine();
        System.out.printf("pw 입력 : ");
        pw = in.nextLine();

        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection(URL, id, pw);
            System.out.println("Connection OK" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("로그인 정보가 올바르지 않습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return connection;
    }

    public static Connection userchange() {
        String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimeZone=Asia/Seoul";
        String id;
        String pw;

        System.out.println("로그인 정보를 변경합니다.");
        System.out.println("로그인을 합니다.");
        Scanner in = new Scanner(System.in);
        System.out.printf("id 입력 : ");
        id = in.nextLine();
        System.out.printf("pw 입력 : ");
        pw = in.nextLine();

        Connection connection = null;

        try {
            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection(URL, id, pw);
            System.out.println("Connection OK" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("로그인 정보가 올바르지 않습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return connection;
    }

}
