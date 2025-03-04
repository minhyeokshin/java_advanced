package jdbc.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.boardenum.*;

/**
 * packageName   : jdbc.advanced.users
 * fileName      : DBUtil
 * author        : a
 * date          : 2025-02-28
 * description   : 데이터베이스 연결 작업 클래스
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-02-28        a
 */
public class DBUtil {
    static int loginerror = 3;
    public static Connection getConnection() {
        String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul";
        String id;
        String pw;

        System.out.println("로그인을 시도합니다.");
        Scanner in = new Scanner(System.in);
        System.out.printf("ID 입력 : ");
        id = in.nextLine();
        System.out.printf("PW 입력 : ");
        pw = in.nextLine();

        Connection connection = null;

        try {

            // 1. JDBC 드라이버 등록  : MYSQL DB 접근 하기 위한 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection(URL, id, pw);
            System.out.println("Connection OK" + connection);
        } catch (ClassNotFoundException e) {
            System.out.println("로그인 에러");
        } catch (SQLException e) {
            loginerror--;
            if (loginerror > 0) {
                System.out.println("로그인 실패, 남은횟수 : " + loginerror);
                getConnection();
            } else System.out.println("프로그램을 종료합니다.");
        }

        return connection;
    }

}