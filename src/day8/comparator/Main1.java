package day8.comparator;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나ㅏ이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세

@Data
@AllArgsConstructor
public class Main1 {

    public static void main(String[] args) {



        @Data
        class User {
            private String name;
            private int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

            User user1 = new User("홍길동",25);
            User user2 = new User("최영희",24);
            User user3 = new User("김철수",24);
            User user4 = new User("홍길동",30);
            User user5 = new User("홍길동",22);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

            Collections.sort(users, Comparator.comparing(User::getAge));
                for (User user : users) System.out.println(user.name + " " + user.age + "세");

        System.out.println("==========================================================================");
        Collections.sort(users, Comparator.comparing(User::getName));
        for (User user : users) System.out.println(user.name + " " + user.age + "세");

        System.out.println("==========================================================================");
        Collections.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName));
        for (User user : users) System.out.println(user.name + " " + user.age + "세");
    }
}
