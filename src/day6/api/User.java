package day6.api;



//객체복사 메소드를 사용하기 위해서는 Cloneable 인터페이스를 구현하여 clone()을 재정의하여 사용한다.
public class User implements Cloneable{

    private String name;

    public void setName(String name){
        this.name = name;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
