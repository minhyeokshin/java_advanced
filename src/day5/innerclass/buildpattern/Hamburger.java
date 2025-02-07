package day5.innerclass.buildpattern;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

//실습 : 필수사항에 세트는 반드시 음료가 포함되는 햄버거 셋트이다.
//음료가 포함되어 있는 햄버거를 만들어 주세요.
//치킨버거(토핑 : 치즈,야채,베이컨 ) + 콜라 세트 메뉴 생성
@Data
public class Hamburger {
    //필수 멤버
    private String bun;
    private String patty;
    private String Vegetable;
    private String Drink;

    //선택 멤버
    private boolean cheese;
    private boolean lettuce;
    private boolean tomato;
    private boolean bacon;


        private Hamburger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.Vegetable = builder.Vegetable;
        this.Drink = builder.Drink;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.bacon = builder.bacon;
    }

    public static class BurgerBuilder {
        private String Drink;
        private String Vegetable;
        private String bun;
        private String patty;

        private boolean cheese = false;
        private boolean lettuce = false;
        private boolean tomato = false;
        private boolean bacon = false;

        public BurgerBuilder(String bun, String patty,String Vegetable,String Drink){
            this.bun = bun;
            this.patty = patty;
            this.Vegetable = Vegetable;
            this.Drink = Drink;

        }
        //선택적 요소를 단계적으로 추가할 수 있도록 메서드를 설계

        public BurgerBuilder addCheese(){
            this.cheese =true;
            return this;   //
        }

        public BurgerBuilder addlettuce(){
            this.lettuce =true;
            return this;   //
        }

        public BurgerBuilder addtomato(){
            this.tomato =true;
            return this;   //
        }

        public BurgerBuilder addBacon(){
            this.bacon =true;
            return this;   //
        }
        //핵심 최종적으로 BurgerBuilder 객체를 반환하는 메서드를 생성
        public Hamburger build(){
            return new Hamburger(this);
        }


    } // end of inner class

    @Override
    public String toString() {

        return "Hamburger Set\n{" +
                "Drink=" + Drink +
                ", bun=" + bun +
                ", patty=" + patty +
                ", Vegetable= " + Vegetable +
                ", cheese=" + cheese +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                ", bacon=" + bacon +
                '}';
    }
}