package day5.innerclass.ex02;

public class ABClass {
    public static void main(String[] args) {
        //A클래스 생성
        A a = new A();
        //B 객체 생성
        A.B b = a.new B();
    }
}
