package day10.lamda.ex03;

public class Main {

    public static void main(String[] args) {
        Person calculator = new Person();
        calculator.setX(5);
        calculator.setY(10);
        calculator.calculate(
                (x,y) -> {
                    double result = x+y;
                    return result;
                }
        );

    }
    public static double calculate(double x,double y){
        return x+y;
    }
}
