package day5.innerclass.ex06;

public class Hamburger {
        //필수 멤버
    private int bun;
    private int patty;

    //선택 멤버
    private int cheese;
    private int lettuce;
    private int tomato;
    private int bacon;

    public Hamburger(int bun,int patty,int cheese){
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
    }
}
