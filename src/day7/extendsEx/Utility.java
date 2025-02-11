package day7.extendsEx;

public class Utility {

    public static <T> void printArray(T[] array){
        for(T element : array) System.out.println(element);
    }

    public static void main(String[] args) {
        String[] strArray = {"Hello","Java"};
        Utility.printArray(strArray);
        Integer[] integers = {1,2,3,4,5};
        Utility.printArray(integers);
    }
}
