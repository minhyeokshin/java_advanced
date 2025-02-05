package day3;

public interface RemoteControl {

    //가장 큰 볼륨을 저장할 멤버 30 값 할당
    public static final int MAX_VOLUME = 30;
    //가장작은 볼륨을 저장할 멤버 0 할당
    int MIN_VOLUME = 0; //인터페이스기 떄문에 모든 필드는 상수처리 . 컴파일러가 public static final 은 알아서 붙여줌


    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);

}
