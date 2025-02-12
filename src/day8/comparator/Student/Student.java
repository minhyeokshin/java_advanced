package day8.comparator.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private String name;
    private int korean;
    private int math;
    private int eng;
    private int total;
    private double avg;
    private String grade;
    private int rank = 0;

    public Student(String name, int korean, int math, int eng) {

        this.name = name;
        this.korean = korean;
        this.math = math;
        this.eng = eng;
        this.total = korean + math + eng;
        this.avg = (double) total / 3;


        if (avg >= 90) grade = "A";
        else if (avg >= 80) grade = "B";
        else if (avg >= 70) grade = "C";
        else if (avg >= 60) grade = "D";
        else grade = "F";


    }

    @Override
    public String toString() {
        return name + "\t" +
                korean + "\t\t" +
                math + "\t\t" +
                eng + "\t\t" +
                total + "\t\t" +
                (Math.round(avg * 100.f) / 100.f) + "\t\t" +
                grade + "\t\t" +
                rank + "\t\t";
    }

    @Override
    public int compareTo(Student o) {
        if (this.avg > o.avg) {
            return -1;
        } else if (this.avg == o.avg) {

            if (this.korean > o.korean) return -1;

            else if (this.korean == o.korean) {


                if (this.math > o.math) return -1;
                else if (this.math == o.math) {
                    if (this.eng > o.eng) return -1;
                    else if (this.eng == o.eng) return 0;
                    else if (this.eng < o.eng) return 0;

                }

            }
        }
        return 0;
    }



    public static void assignRanks(List<Student> studentlist) {
        Collections.sort(studentlist); // 평균 점수 기준 정렬
        int rank = 1;
        int rank2 = 1;
        for (int i = 0; i < studentlist.size(); i++) {
            if (i > 0 && studentlist.get(i).getAvg() > studentlist.get(i - 1).getAvg()) {
                if (studentlist.get(i).getKorean() > studentlist.get(i - 1).getKorean()){
                    studentlist.get(i).setRank(studentlist.get(i - 1).getRank());
                    rank2++;
                }
                else if (studentlist.get(i).getMath() > studentlist.get(i - 1).getMath()){
                    studentlist.get(i).setRank(studentlist.get(i - 1).getRank());
                    rank2++;
                }
                else if (studentlist.get(i).getEng() > studentlist.get(i - 1).getEng()){
                    studentlist.get(i).setRank(studentlist.get(i - 1).getRank());
                    rank2++;
                }
            } else {
                studentlist.get(i).setRank(rank);
                rank2 = 1;
            }
            rank += rank2;
        }
    }



    }


