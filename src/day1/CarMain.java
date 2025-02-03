package day1;

public class CarMain {
    public static void main(String[] args) {
    Car mycar1 = new Car();
    SportsCar mycar2 = new SportsCar();

    for (int i = 1;i<=3;i++){
        mycar1.speedUP();
    }
    for (int i = 1;i<=5;i++){
        mycar2.speedUP();
        }

    mycar1.show();
    mycar2.show();
}
    }
