package day2.exception.ex02.resourceEx;

public class MyResource implements AutoCloseable{
    private String name;

    public MyResource(String name){
        this.name = name;
        System.out.println("[My Resource] (" + name + ") 열기");
    }

    public String read1(){
        System.out.println("[My Resource] (" + name + ") 열기");
        return "200";
    }

    public String read2(){
        System.out.println("[My Resource] (" + name + ") 열기");
        return "abc";
    }


    @Override
    public void close() throws Exception{}
}
