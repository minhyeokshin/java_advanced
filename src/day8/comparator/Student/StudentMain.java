package day8.comparator.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMain extends StudentData{

    public static void main(String[] args) {

        List<Student> studentList = StudentData.loadStudent();

        //등수 매기기
        Student.assignRanks(studentList);
        //출력
        StudentUtil.studentprint(studentList);
    }
}




