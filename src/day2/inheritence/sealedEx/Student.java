package day2.inheritence.sealedEx;

public class Student extends Manager{
        // 봉인된 Person 클래스의 permits 가 되지않았으므로 상속불가
        // Person 자식 클래스인 Employee도 해제가 되지않았고 상속불가.
        //봉인 해제된 Manager 클래스는 상속가능


    @Override
    public void work() {
        System.out.println("공부를 열심히합니다.");
    }
}
