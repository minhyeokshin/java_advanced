package day7.reflectionEx;

public class Person {

    public String name;
    private int age;
    public static int weight = 50;

    public Person(){}
    //이름과 나이를 입력받는 생성자
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void getField(){
        System.out.printf("이름 : %s\t 나이 :%d\n",name,age);
    }
    public int total(int left,int right){
        return left+right;
    }
    public static int intstaticTotal(int left,int right){
        return left+right;
    }
    private int privateTotal(int left,int right){
        return left+right;
    }
}
