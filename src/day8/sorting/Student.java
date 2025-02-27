package day8.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private int sno;
    private String name;



    @Override
    public int compareTo(Student o) {
//        if (this.sno > o.sno) return 1;
//        else if (this.sno == o.sno) return 0;
//        else return -1;
//        return this.sno - o.sno;

        if ((this.sno - o.sno) >0){
            return 1;
        } else if ((this.sno - o.sno) == 0) {
            if(this.name.charAt(0) > o.name.charAt(0)){
                return 1;
            }else return -1;
        } else {
            return  -1;
        }

        }

    }

