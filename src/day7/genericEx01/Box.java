package day7.genericEx01;

import java.util.ArrayList;

public class Box<T>{ //T는 Box의 인스턴스를 생성할 때 어떤 참조타입으로 대체될 수 있는 타입매개변수
    private T item;
    private int count = 0; //item의 수를 추적하는 컨테이너
    public static ArrayList<String> ItemList = new ArrayList<>();

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
        ItemList.add((String) item);
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
