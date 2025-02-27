package day1.Homework.Test2;

public class Coffee extends Beverage {

    public int amount;



    public Coffee(String name){
        super(name);
        this.setName(name);
        amount++;
    }

    @Override
    public void calcPrice() {

    }
}
