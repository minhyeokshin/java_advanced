package day4.newCarEx;

public class DriveMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.drive(new Taxi());
        driver.drive(new Bus());
        driver.drive(new Horse());
    }
}
