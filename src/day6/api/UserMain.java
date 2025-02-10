package day6.api;

public class UserMain {
    public static void main(String[] args) {

        //얕은 복사(shallow copy) : 주소값 복사
        User user = new User();
        user.setName("Shin");
        User copy = user;

        System.out.println(user.hashCode());
        System.out.println(copy.hashCode());
        System.out.println(user.equals(copy));

        //깊은 복사(deep copy)
        try {
            User user1 = new User();
            user1.setName("Shin");
            User copy1 = (User) user1.clone();

            System.out.println(user1.hashCode());
            System.out.println(copy1.hashCode());
            System.out.println(user1.equals(copy1));

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
