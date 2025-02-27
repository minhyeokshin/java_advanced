package day10.lamda.ex02;

//홍길동씨가 프로그래밍을 합니다. 출력
//"프로그래밍은 정말 재미있어" 말합니다. 출력

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("홍길동","프로그래밍","프로그래밍은 정말 재미있어");
        person.action1(
                (name,job) -> {
                    System.out.printf("%s씨가 %s을 합니다.%n",name,job);
                }
        );
        person.action2(
                (contents) -> {
                    System.out.println(contents);}
        );



    }
}
