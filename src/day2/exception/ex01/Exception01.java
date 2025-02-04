package day2.exception.ex01;

import java.util.Scanner;

public class Exception01 {
    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        System.out.println("프로그램 시작\n");
        printLength("This is java Programing");
        printLength(null);

        try{
            String classname = in.nextLine();
            Class.forName(classname);
            System.out.printf("%s 클래스가 존재합니다.%n",classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("프로그램 종료\n");
    }

    public static void printLength(String data){
        int result = 0;
        try{
            result = data.length();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 예외 정보를 얻는 방법1
//            System.out.println(e.toString());   // 예외 정보를 얻는 방법2
//            e.printStackTrace();                // 예외 정보를 얻는 방법3
        } finally {
            System.out.println("마무리 실행");
        }

        System.out.println("문자의 수 : "+result);
    }

}
