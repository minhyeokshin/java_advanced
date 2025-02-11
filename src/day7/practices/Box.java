package day7.practices;


//어떤 타입의 객체든 저장할 수 있는 제너릭 클래스 Box. 객체를 설정하고 가져오는 메소드를 구현하세요

public class Box<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Box box = new Box<>();
        box.setItem("연필,지우개");
        System.out.println(box.getItem());
        box.setItem(123);
        System.out.println(box.getItem());
    }
}