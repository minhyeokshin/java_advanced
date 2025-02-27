package day8.set;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object o) {
        //nama과 age가 같다면 true return

        if (o instanceof Member targer) {
            return targer.name.equals(name) && (targer.age == age);
        } else return false;
    }

}
