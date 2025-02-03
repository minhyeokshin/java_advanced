package day1;

public class SmartPhone extends Phone{

    public boolean wifi;

    public SmartPhone(String color,String model){
        this.color = color;
        this.model = model;
    }

    @Override
    public void bell(){
        System.out.println("기존벨소리");
        super.bell();
        System.out.println("추가된 벨소리");
        System.out.println("벨이 띠리링울린다");
    }

    public void setwifi(boolean wifi){
        this.wifi = wifi;
        if(this.wifi != false) internet();
    }

    public void  internet(){
        System.out.println("인터넷을 연결합니다.");
    }
}
