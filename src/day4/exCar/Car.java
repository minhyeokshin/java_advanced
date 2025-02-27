package day4.exCar;

public class Car {


    Tire tire1;
    Tire tire2;

    public Car(Tire tire1,Tire tire2){
        this.tire1 = tire1;
        this.tire2 = tire2;
    }


    public void run() {
        tire1.roll();
        tire2.roll();     //인터페이스에 선언된 추상메소드를 호출했다.  구현 객체의 roll메소드를 설정
    }

    public void ChangeTire(Tire tire1,Tire tire2){
        this.tire1 = tire1;
        this.tire2  = tire2;
    }
}