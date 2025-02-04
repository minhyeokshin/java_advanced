package day1.Homework.Test1;

public class Circle extends Shape{

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculationArea() {
        System.out.println(Math.PI * radius * radius);
    }

    @Override
    void print() {
        System.out.printf("원의 면적은 ");
        calculationArea();
    }
}
