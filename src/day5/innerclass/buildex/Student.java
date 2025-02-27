package day5.innerclass.buildex;

import lombok.Data;

@Data
public class Student {
    public static void main(String[] args) {
//        StudentBuild studentA = new StudentBuild();
        StudentBuild studentB = new StudentBuild("001","Shin","Math");
//        studentB.setAddress("ㅇ");
        System.out.println(studentB);
    }
}
