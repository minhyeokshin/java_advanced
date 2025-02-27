package day10.lamda.ex03;


//Person클래스는 Calculable을 매개변수로 갖는 calculate 메소드를 갖고있다.
public class Person {
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    void calculate(Calculabe calculabe){
        double result = calculabe.calculate(this.x,this.y);
        System.out.println("계산결과 : "+result);
    }


}
