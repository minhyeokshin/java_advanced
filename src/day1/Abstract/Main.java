package day1.Abstract;


public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
        animalSound(dog); // 자동타입변환
        animalSound(cat);
    }

    public static void  animalSound(Animal animal){
        if (animal instanceof Cat)
        animal.sound();                 // <------재정의된 메서드 호출
    }

}
