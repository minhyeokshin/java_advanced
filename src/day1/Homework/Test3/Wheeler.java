package day1.Homework.Test3;

public abstract class Wheeler {
    protected int velocity;
    protected String carName;
    protected int wheelNumber;

    abstract public void speedUp(int speed);

    abstract public void speedDown(int speed);

    public void stop(){
        velocity = 0;
        System.out.println("�������·� �ӵ��� 0���� �ʱ�ȭ�մϴ�.");
    }
}