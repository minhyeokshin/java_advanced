package day2.inheritence.sealedEx;

public sealed class Person permits Employee,Manager {

    public String name;

    public void work(){
        System.out.println("하는 일이 결정 되지 않았습니다.");
    }
}
