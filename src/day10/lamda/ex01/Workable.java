package day10.lamda.ex01;
//Workable 인터페이스는 함수형 인터페이스이며 반환값이 없는 work() 단일 추상 메소드를 가지고 있습니다.

@FunctionalInterface
public interface Workable {
    void work(String name, String job);
}
