package day10.lamda.ex02;

//Person클래스는 Workable을 매개변수로 갖는 action 메소드를 갖고있다.
public class Person {

    private String name;
    private String job;
    private String contents;

    public Person(String name,String job,String contents){
        this.name = name;
        this.job = job;
        this.contents = contents;
    }

public void action1(Workable workable){
    workable.work(name,job);
}

    public void action2(Speakalbe speakalbe){
        speakalbe.speak(contents);
    }






}
