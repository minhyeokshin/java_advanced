package day5.innerclass.buildpattern;

import lombok.Data;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger PersonA = new Hamburger.BurgerBuilder("플랫", "쇠고기","야채","콜라").addCheese().addBacon().addtomato().addlettuce().build();
        System.out.println(PersonA);
        System.out.println();

        PersonA.setBun("허니오트");
        System.out.println(PersonA.getBun());
        System.out.println();
        System.out.println(PersonA);

    }
}
