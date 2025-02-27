package day6.api;
//데이터 전달을 위한 역할 : DTO
public class Member1 {
    private final String name;
    private final int age;

    public Member1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String name(){return this.name;}
    public int age(){return this.age;}
}
