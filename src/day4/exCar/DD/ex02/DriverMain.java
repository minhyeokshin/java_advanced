package day4.exCar.DD.ex02;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);

        Hourse hourse = new Hourse();
        driver.drive(hourse);
    }
}
