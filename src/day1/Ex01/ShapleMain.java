package day1.Ex01;

import day1.ExtendsEx.C;

import java.util.ArrayList;

class Shape{}
class Rectangle extends Shape{}
class Triangle extends Shape{}
class Circle extends Shape{}

public class ShapleMain {

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Rectangle());
        shapes.add(new Rectangle());
        shapes.add(new Rectangle());

        shapes.add(new Triangle());
        shapes.add(new Triangle());

        shapes.add(new Circle());


        shapes.forEach(each -> System.out.println(each));

    }
}
