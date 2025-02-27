package day1.Homework.Test1;

public class TestShape {
    public static void main(String[] args) {
        //배열 생성
        Shape [] shape = new Shape[2];
        //객체 생성
        Circle circle = new Circle();
        Rectangular rectangular = new Rectangular();
        //데이터 입력
        circle.setRadius(10);
        rectangular.setHight("20");
        rectangular.setWidth(10);
        //배열 데이터 대입
        shape[0] = circle;
        shape[1] = rectangular;
        //출력
        for (int i = 0;i<shape.length;i++){
            shape[i].print();
        }

    }
}
