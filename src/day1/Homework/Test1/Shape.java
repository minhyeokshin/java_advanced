package day1.Homework.Test1;

abstract class Shape {
    protected double area;
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public void Shape(){}
    public void Shape(String name){this.name = name;}
    public abstract void calculationArea();
    void print(){}

}
