package day5.innerclass;

public class A {
    //인스턴스 멤버클래스
    class B{}

    //인스턴스 필드 값으로 B객체 생성 대입
    B field = new B();

    //생성자

    A(){
        B b = new B();
    }
}
