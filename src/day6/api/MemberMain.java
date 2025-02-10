package day6.api;

public class MemberMain {
    public static void main(String[] args) {
        Member m1 = new Member("ssg1");
        Member m2 = new Member("ssg1");
        Member m3 = new Member("ssg3");

        if (m1.equals(m2)){
            System.out.println("동일한 회원입니다.");
        }else {
            System.out.println("동일한 회원이 아닙니다.");
        }

    }
}
