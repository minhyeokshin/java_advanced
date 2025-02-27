package day4.newCarEx;

public class Driver {

    public void drive(Vehicle vehicle){
    if(vehicle instanceof Taxi || vehicle instanceof Bus) vehicle.run();
    else {System.out.println("올바른 교통수단을 선택하세요.");
        System.out.println();}
    }
}
