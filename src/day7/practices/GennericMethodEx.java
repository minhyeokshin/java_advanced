package day7.practices;

import java.lang.reflect.Type;
import java.util.ArrayList;

//어떤 타입의 배열을 받아 요소를 출력하는 제너릭 메서드 printArray를 작성하세요
public class GennericMethodEx{


    public static <T> void printArray(ArrayList <T> array){
        for(T element : array)
            System.out.println(element);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0;i<5;i++){
            array.add(i);
        }
        printArray(array);
    }

}