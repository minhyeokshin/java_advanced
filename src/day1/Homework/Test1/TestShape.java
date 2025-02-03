package day1.Homework.Test1;

public class TestShape {
    public static void main(String[] args) {
        Shape [] shape = new Shape[2];
        Circle circle = new Circle();
        Rectangular rectangular = new Rectangular();
        circle.setRadius(10);
        rectangular.setHight("20");
        rectangular.setWidth(10);
        shape[0] = circle;
        shape[0].print();
        shape[1] = rectangular;
        shape[1].print();


    }
}
