package day10.lamda.ex02;

public class SingerMain {
    public static void main(String[] args) {
        //황가람은 가수입니다. 출력
        //"저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다." 말합니다.
        //"반딧불"노래를 부릅니다.
        Person person1 = new Person("황가람","가수","반딧불");

        person1.action1(
                (name,job) -> {
                    System.out.printf("%s는 %s입니다.%n",name,job);
                    System.out.println("저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다.");
                }        );
        person1.action2(
                (contents) -> {
                    System.out.println("대표 노래 : "+contents);
                }
        );
        System.out.println();
        //조수미는 오페라 가수입니다. 출력
        //"저를 오랫동안 사랑해주셔서 감사합니다." 말합니다 출력
        //"밤의 아리아" 노래를 부릅니다.
        Person person2 = new Person("조수미","오페라가수","밤의 아리아");
        person2.action1(
                (name,job) -> {
                    System.out.printf("%s는 %s입니다.%n",name,job);
                    System.out.println("저를 오랫동안 사랑해주셔서 감사합니다.");
                }        );
        person2.action2(
                (contents) -> {
                    System.out.println("대표 노래 : "+contents);
                }
        );


    }
}
