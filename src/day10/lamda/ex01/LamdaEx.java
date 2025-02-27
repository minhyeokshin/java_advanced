package day10.lamda.ex01;

public class LamdaEx{

    public static void main(String[] args) {

        action(
                (x, y) -> {
                    int result = x + y;
                    System.out.println("result1 : " + result);
                }
        );

        action(
                (x, y) -> {
                    int result = x - y;
                    System.out.println("result2 : " + result);
                }
        );

    }
        public static void action(Calculable calculabe){
            int x = 10;
            int y= 20;
            calculabe.calculate(x,y);
        }




}
