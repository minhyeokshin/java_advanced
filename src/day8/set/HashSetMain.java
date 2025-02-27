package day8.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Member> members = new HashSet<>();

        //회원 가입해서 정보를 저장
        members.add(new Member("홍길동1",30));
        members.add(new Member("홍길동2",31));
        members.add(new Member("홍길동3",32));
        members.add(new Member("홍길동4",33));
        members.add(new Member("홍길동5",34));


        System.out.println("Set : "+members.size());
        for (Member member : members) System.out.println(member.name);
        System.out.println();

        //객체를 반복자 Iterator을 이용하여 처리
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()){
            //객체를 하나씩 꺼내오기
            Member member = iterator.next();
            System.out.println(member.name + " " + member.age +"세");
            iterator.remove();
            int size = members.size();
            System.out.println("현재 회원 수 : "+size);
        }
    }
}
