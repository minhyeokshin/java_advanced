package day8.comparator.Student;


import java.util.List;

public class StudentUtil {

    public static void studentprint(List<Student> studentlist) {
        System.out.println("******************************************************************");
        System.out.println("\t\t\t\t\t\t\t학생 관리 시스템\t\t\t\t");
        System.out.println("******************************************************************");
        System.out.println("이름\t\t국어\t\t수학\t\t영어\t\t총점\t\t평균\t\t\t학점\t\t등수");
        studentlist.forEach(System.out::println);
        System.out.println("******************************************************************");
    }


    public static void studentassignprint(List<Student> studentlist) {
//        studentlist.sort(Student::compareTo);
        System.out.println("******************************************************************");
        System.out.println("\t\t\t\t\t\t\t학생 관리 시스템\t\t\t\t");
        System.out.println("******************************************************************");
        System.out.println("이름\t\t국어\t\t수학\t\t영어\t\t총점\t\t평균\t\t\t학점\t\t등수");
        studentlist.forEach(System.out::println);
        System.out.println("******************************************************************");
    }


}



