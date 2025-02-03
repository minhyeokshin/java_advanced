package day1;

class A{
    protected String field1;

    protected A(){}
    protected A(String field1) {
        this.field1 = field1;
    }
    protected void method1(){
        System.out.println("A클래스의 method1()");
    }
}

class B{
    protected String field2;

    protected B(){

    }

    public B(String field2) {
        this.field2 = field2;
    }
    protected void method1(){
        System.out.println("B클래스의 method1");
        A a = new A();
        a.field1 = "value1";
        a.method1();
    }
}

public class ProtectedMain {
}
