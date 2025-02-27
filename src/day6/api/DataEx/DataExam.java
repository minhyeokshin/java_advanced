package day6.api.DataEx;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DataExam {
    public static void main(String[] args) {
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);
        System.out.println("================");

        SimpleDateFormat now1 = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        String strNow2 = now1.format(now);
        System.out.println(strNow2);
    }
}
