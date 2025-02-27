package day2.exception.ex02.resourceEx;

public class TryWithResourceEx {

    public static void main(String[] args) {
        try(MyResource resource = new MyResource("A")){
            String data = resource.read1();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리 : " +e.getMessage());
        }

        System.out.println();

        try(MyResource resource = new MyResource("A")){
            String data = resource.read2();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리 : " +e.getMessage());
        }
        System.out.println();

        MyResource resource1 = new MyResource("A");
        MyResource resource2 = new MyResource("A");

        try(resource1;resource2){
            String data1 = resource1.read1();
            String data2 = resource2.read2();
        } catch (Exception e) {
            System.out.println("try with resource : " +e.getMessage());
        }

    }
}