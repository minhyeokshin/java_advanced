package day8.upcasting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class UpcastingMain {
    public static void main(String[] args) {


        Collection<Number> data1 = new ArrayList<>();
        data1.add(1);
        Collection<Number> data2 = new HashSet<>();
        data2.add(2);
        data2.add(3);
        data2.add(5);
        Collection<Number> data3 = new LinkedList<>();
        data3.add(3);
        data3.add(4);
//        data3.remove(3);
        data3.removeAll(data2);
        data2.clear();

        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
}
