package day6.api.DataEx;

import day1.ExtendsEx.C;

import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        int ampm = now.get(Calendar.AM_PM);
        int hour = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.println(year+"년 "+month+"월 "+day+"일 "+week+ "요일 \t"+ampm+ "시 "+hour+"분 "+second+"초 ");

    }
}
