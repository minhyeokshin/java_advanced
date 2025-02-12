package day8.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나ㅏ이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
@AllArgsConstructor
@Data

public class Main {
    public static int num = 0;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {



        class User implements Comparable<User> {
            final String name;
            final int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            //            @Override
//            public String toString() {
//                return "User{" +
//                        "name='" + name + '\'' +
//                        ", age=" + age +
//                        '}';
//            }


            @Override
            public int compareTo(User o) {
                if (num == 1) {
                    if ((this.age - o.age) > 0) {
                        return 1;
                    } else if ((this.age == o.age)) {
                        if (this.name.charAt(0) > o.name.charAt(0)) {
                            return 1;
                        } else return -1;
                    } else return -1;
                } else if (num == 2) {
                    if ((this.age - o.age) > 0) {
                        return -1;
                    } else if ((this.age == o.age)) {
                        if (this.name.charAt(0) > o.name.charAt(0)) {
                            return -1;
                        } else return 1;
                    } else return 1;
                } else {
                    System.out.println("올바른 번호를 선택하세요.");
                    return 0;
                }
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
        System.out.println("정렬 전");
//        users.forEach(System.out::println);
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%s %d세%n",users.get(i).name,users.get(i).age);
        }

        System.out.println();
        System.out.println("1. 오름차순 정렬 2. 내림차순 정렬 ");
        System.out.printf("선택하세요 : ");
        num = in.nextInt();
        System.out.println("정렬 후");
        Collections.sort(users);
//        users.forEach(System.out::println);
        for (int i = 0; i < users.size(); i++) {

            if (num != 1 && num != 2){
                break;
            }
            System.out.printf("%s %d세%n",users.get(i).name,users.get(i).age);
        }



    }
}
