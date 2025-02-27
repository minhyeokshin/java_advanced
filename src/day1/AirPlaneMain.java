package day1;

public class AirPlaneMain {
    public static void main(String[] args) {
        //AirPlane 생성 ,이륙,날다,착륙하다 수행
        AirPlane airPlane = new AirPlane();
        airPlane.takeOff();
        airPlane.fly();
        airPlane.land();
        //SuperAirPlane 생성, 이륙,날다,착륙 수행
        SuperAirPlane superAirPlane = new SuperAirPlane();
        superAirPlane.takeOff();
        superAirPlane.flyMode = SuperAirPlane.ADVANCED;
        superAirPlane.fly();
        superAirPlane.land();

    }
}
