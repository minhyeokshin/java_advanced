package day1;

public class SuperAirPlane extends AirPlane{
    //상수 선언
    public static final int NORMAL = 1;
    public static final int ADVANCED = 2;

    //상태 필드 선언
    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if(flyMode == ADVANCED){
            System.out.println("초음속 비행");
        } else {
            super.fly();
        }
        super.fly();
    }
}
