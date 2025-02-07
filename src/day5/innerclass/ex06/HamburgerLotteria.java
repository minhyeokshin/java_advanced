package day5.innerclass.ex06;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger PersonA = new Hamburger(2,1,2);
        Hamburger PersonB = new Hamburger(2,3,1);
    }
}

//생성자 만으로는 필드를 선택적으로 생략할 수 없는 방식
//타입이 다양할수록 생성자 메서자 수가 늘어나기 때문에 가독성과 유지보수성이 떨어진다.