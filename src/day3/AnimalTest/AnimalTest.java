package day3.AnimalTest;

public class AnimalTest {

    public static void main(String[] args) {
        Animal dog = new Dog(8, "개");
        Animal chicken = new Chicken(3, "닭");
        Chicken cheatableChicken = new Chicken(5, "날으는 닭");


        for (int i = 1; i <= 3; i++) {
            System.out.println(i+"시간 후");
            dog.run();
            chicken.run();
            if (cheatableChicken instanceof Cheatable) {
                cheatableChicken.fly();
            }else cheatableChicken.run();

            System.out.println(dog.getName() + "의 이동거리=" + dog.getDistance());
            System.out.println(chicken.getName() + "의 이동거리=" + chicken.getDistance());
            System.out.println(cheatableChicken.getName() + "의 이동거리=" + cheatableChicken.getDistance());
            System.out.println();
        }

    }
}

