package day1.Homework.Test1;

abstract class Shape {
    protected double area;
    public String name;

   public void Shape(String name){
       this.name = name;
   }
    public abstract void calculationArea();

    void print(){}

}
