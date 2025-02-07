package day5.innerclass.buildex;

import day5.innerclass.buildpattern.Hamburger;
import lombok.Builder;
import lombok.Data;

@Data

public class StudentBuild {
    private String id;
    private String name;
    private String major;

    private boolean grade;
    private boolean phoneNumber;
    private boolean address;

    private StudentBuild(StudentBuilder studentBuild){
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public StudentBuild(StudentBuild studentBuild) {

    }

    public static class StudentBuilder {

        private String id;
        private String name;
        private String major;

        private boolean grade = false;
        private boolean phoneNumber = false;
        private boolean address = false;
    }



    public StudentBuild(String id,String name,String major){
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public StudentBuild.StudentBuilder addgrade(){
        this.grade =true;
        return this.addgrade();
    }

    public StudentBuild.StudentBuilder addphoneNumber(){
        this.grade =true;
        return this.addphoneNumber();
    }

    public StudentBuild.StudentBuilder addaddress(){
        this.grade =true;
        return this.addaddress();
    }


    //핵심 최종적으로 BurgerBuilder 객체를 반환하는 메서드를 생성
    public StudentBuild build(){
        return new StudentBuild(this);
    }

    @Override
    public String toString() {

        return "학번 : " + id +
                ", name : " + name +
                ", major : " + major +
                ", grade : " + grade +
                ", phoneNumber : " + phoneNumber +
                ", address : " + address;
    }
}
