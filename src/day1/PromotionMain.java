package day1;

public class PromotionMain {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal animal = (Cat)cat;
        //cat과 animal 변수는 타입만 다른 뿐이지 동일한 Cat 객체를 참조한다.

        System.out.println(cat == animal);
    }
}
