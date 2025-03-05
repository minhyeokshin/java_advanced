package jdbc.callablestmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤을 적용한 Connection 객체 적용
public class DBUTIL {
    private static Connection conn = null; //내부에서 생성하여 선택적으로 공유할 수 있도록 private static 선언

    //외부에서 인스턴스 생성을 막기 위해서
    private DBUTIL(){}

    public static Connection getConnection(){

        if (conn != null){
            return conn;
        }

        try {
            //1. MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. MySQL 연결 URL
            String URL = "jdbc:mysql://localhost:3306/ssgdb?useSSL=false&serverTimeZone=UTC";
            String id = "ssg";
            String pw = "ssg1234";
            conn = DriverManager.getConnection(URL, id, pw);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다." + e.getMessage());
        } catch (SQLException e1){
            e1.printStackTrace();
        }
        //3."연결 성공" 메세지 출력
        System.out.println("Connection OK" + conn);
        return conn;
    }

}
