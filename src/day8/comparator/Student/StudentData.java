package day8.comparator.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    public static List<Student> loadStudent() {
        List<Student> studentlist = new ArrayList<>();

        studentlist.add(new Student("학생1", 86, 73, 64));
        studentlist.add(new Student("학생2", 59, 90, 74));
        studentlist.add(new Student("학생3", 61, 58, 62));
        studentlist.add(new Student("학생4", 89, 65, 91));
        studentlist.add(new Student("학생5", 66, 64, 53));
        studentlist.add(new Student("학생6", 98, 70, 81));
        studentlist.add(new Student("학생7", 76, 83, 97));
        studentlist.add(new Student("학생8", 55, 77, 84));
        studentlist.add(new Student("학생9", 92, 67, 58));
        studentlist.add(new Student("학생10", 63, 93, 79));
        studentlist.add(new Student("학생11", 88, 91, 87));
        studentlist.add(new Student("학생12", 70, 62, 75));
        studentlist.add(new Student("학생13", 82, 85, 99));
        studentlist.add(new Student("학생14", 95, 68, 54));
        studentlist.add(new Student("학생15", 79, 97, 90));
        studentlist.add(new Student("학생16", 83, 72, 88));
        studentlist.add(new Student("학생17", 67, 79, 85));
        studentlist.add(new Student("학생18", 74, 95, 66));
        studentlist.add(new Student("학생19", 60, 89, 71));
        studentlist.add(new Student("학생20", 99, 55, 93));
        studentlist.add(new Student("학생21", 72, 98, 86));
        studentlist.add(new Student("학생22", 90, 61, 80));
        studentlist.add(new Student("학생23", 87, 74, 92));
        studentlist.add(new Student("학생24", 54, 99, 77));
        studentlist.add(new Student("학생25", 65, 87, 70));
        studentlist.add(new Student("학생26", 93, 56, 95));
        studentlist.add(new Student("학생27", 81, 66, 60));
        studentlist.add(new Student("학생28", 77, 92, 83));
        studentlist.add(new Student("학생29", 69, 59, 68));
        studentlist.add(new Student("학생30", 58, 78, 82));

        return studentlist;
    }



}