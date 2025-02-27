package day7.extendsEx;



public class CompareUtil {

    public static <T extends Comparable<T>> T max(T a, T b){
        return a.compareTo(b) > 0 ? a : b;
    }
}
