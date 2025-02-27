package day8.sorting;

import java.util.*;

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("Galaxy S25",1200000);
        Product p2 = new Product("Galaxy S25 Plus",1450000);
        Product p3 = new Product("Galaxy S25 Ultra",1700000);
        Product p4 = new Product("Galaxy S25(Old)",700000);
        Product p5 = new Product("Galaxy S25 Plus(Old)",1100000);
        Product p6 = new Product("Galaxy S25 Ultra(Old)",1300000);

        //List 사용
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        System.out.println("리스트 정렬전");
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("리스트 정렬후");
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println();


        //배열[] 사용
        Product[] products = {p1,p2,p3,p4,p5,p6};

        System.out.println("배열 정렬 전");
        Arrays.stream(products).forEach(System.out::println);
        Arrays.sort(products);

        System.out.println();
        System.out.println("배열 정렬 후");
        Arrays.stream(products).forEach(System.out::println);


    }
}
