package day7.genericEx01;

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("인형1");
        stringBox.setItem("기차장난감");
        stringBox.setItem("곰돌이인형");

        for (String doll : Box.ItemList){
            System.out.println(doll);
        }

        System.out.println("장난감 수량 : "+stringBox.getCount());
    }
}
