package day8.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        //객체 저장
        set.add("Java1");
        set.add("Java2");
        set.add("Java3");
        set.add("Java4");
        set.add("Java5");
        set.add("Java6");
        System.out.println(set.size());
    }
}
