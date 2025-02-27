package day8.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student(20250001,"김철수");
        Student student2 = new Student(20240001,"최영희");

        int isBig = student1.compareTo(student2);
        System.out.println(isBig);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.forEach(System.out::println);
        Collections.sort(students);
        students.forEach(System.out::println);

    }
}
