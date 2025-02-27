package day4.interfaceEx4;

public class actionutil {
    public static void action(interfaceA A){
        if(A instanceof C){
            ((C) A).method2();
        }else A.method1();
    }
}
