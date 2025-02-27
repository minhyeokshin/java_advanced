package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import static jdbc.Enun.*;

public class ConnectionMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionEx3 connectionEx3 = new ConnectionEx3();

        Scanner in = new Scanner(System.in);

        String userid;
        String username;
        String userpassword;
        int userage;
        String useremail;

        System.out.printf(INSERT_ID.getMessage());
        userid = in.nextLine();
        System.out.printf(INSERT_NAME.getMessage());
        username = in.nextLine();
        System.out.printf(INSERT_PW.getMessage());
        userpassword = in.nextLine();
        System.out.printf("나이 입력 : ");
        userage = in.nextInt();
        in.nextLine();
        System.out.printf("이메일 입력 : ");
        useremail = in.nextLine();


        connectionEx3.Insert(userid,username,userpassword,userage,useremail);
    }
}
