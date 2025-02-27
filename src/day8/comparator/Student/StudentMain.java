package day8.comparator.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMain extends StudentData{

    public static void main(String[] args) {

        List<Student> studentList = StudentData.loadStudent();


//        //등수 매기기
//        Student.assignRanks(studentList);

        System.out.println("정렬 전 성적");
        StudentUtil.studentprint(studentList);

        //등수 매기기
        Student.assignRanks(studentList);

        //출력
        System.out.println("정렬 후 성적");
        StudentUtil.studentassignprint(studentList);
    }
}




