package day3;

public interface RemoteControlMain {

    public static void main(String[] args) {
        RemoteControl remoteControl;
        remoteControl = new TV();   //인터페이스 자신을 구현한 구현객체(TV)를 담을 수 있다.
        remoteControl.turnOn();    //TV의 전원 ON
        remoteControl = new Radio(); //rc 변수에 Radio 교체(대입)
        remoteControl.turnOn();   // rc를 이용하여 라디오 전원 ON
        //상수는 구현 객체와 관련이 없는 인터페이스의 멤버이므로 인터페이스로 바로 접근하여 상수값을 읽는다.
        System.out.println("리모컨 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
        System.out.println("리모컨 최소 볼륨 : " + RemoteControl.MIN_VOLUME);

        //1. 리모컨을 구입한다.
        RemoteControl remoteControl1;
        //2. 새로산 리모컨에 TV를 설정한다.
        remoteControl1 = new TV();
        //3. 리모컨을 이용하여 TV를 켠다.
        remoteControl1.turnOn();
        //4. 리모컨을 이용하여 볼륨을 10으로 설정한다.
        remoteControl1.setVolume(10);
        //5. 리모컨을 이용하여 TV를 끈다.
        remoteControl1.turnOff();


        //1. 리모컨을 라디오로 페어링 한다.
        remoteControl1 = new Radio();
        //2. 리모컨을 이용하여 라디오를 켠다.
        remoteControl1.turnOn();
        //3. 리모컨을 이용하여 볼륨을 20으로 설정하고 설정값을 확인한다.
        remoteControl1.setVolume(20);
        //4. 리모컨을 이용하여 라디오를 끈다.
        remoteControl1.turnOff();
    }
}