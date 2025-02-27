package day1.Homework.Test1;

public class Rectangular extends Shape{

    private double width;
    private String hight;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }


    @Override
    public void calculationArea() {
        System.out.println(width*Integer.parseInt(hight));

    }
    @Override
    void print() {
        System.out.printf("직사각형의 면적은 ");
        calculationArea();
    }

}
