package day4.newCarEx;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("버스를 운행합니다.");
        System.out.println("버스 요금 지불여부를 확인합니다.");
        System.out.println();
    }
}
