package day1;

public class SmartPhoneMain {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("White","갤럭시S25");

        //Phone 으로부터 상속받은 필드 읽어서 출력
        System.out.println(myPhone.model);
        System.out.println(myPhone.color);
        //SmartPhone 의 필드 읽어서 출력
        System.out.println(myPhone.wifi);
        //Phone 으로부터 상속받은 메소드 호출
        myPhone.bell();
        //SmartPhone 으로부터 상속받은 메소드 출력
        myPhone.setwifi(true);
    }
}
