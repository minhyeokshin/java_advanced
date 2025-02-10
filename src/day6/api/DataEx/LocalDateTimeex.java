package day6.api.DataEx;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeex {
    public static void main(String[] args) {

        //1.현재 시간 받아오기
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd aHH:mm:ss");
        System.out.println("현재시간 : " + now.format(dtf));
    }
}
