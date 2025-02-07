package day5.innerclass.buildpattern;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger PersonA = new Hamburger.BurgerBuilder("플랫", "쇠고기","야채","콜라").addCheese().addBacon().addtomato().addlettuce().build();
        System.out.println(PersonA);

    }
}
