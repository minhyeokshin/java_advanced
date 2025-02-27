package day10.lamda.ex01;

public class ButtonEx {
    public static void main(String[] args) {
        Button button = new Button();

        //버튼을 누르면 "버튼이 클릭되었습니다."구현

       button.setClickListener(
               () -> {System.out.println("버튼이 클릭되었습니다.");}
       );
       button.click();

       Button cancelbutton = new Button();

        cancelbutton.setClickListener(
                () -> {System.out.println("취소 버튼이 클릭되었습니다.");}
        );
        cancelbutton.click();

    }


}
