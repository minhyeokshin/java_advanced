package day2.exception.ex02.resourceEx;

import java.io.*;

public class FileTryWithResourceEx implements AutoCloseable {
    public static void main(String[] args) {

        try (FileWriter file = new FileWriter("data2.txt")) {
            file.write("Java Programming");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileReader fr = new FileReader("data.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {

            while (true) {


                String data = br.readLine();
                if(data != null) {
                    System.out.println(data); }
                else break;

            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void close() throws Exception {

    }
}
// try-with-resources 문의 괄호  () 객체를 생성하는 문장을 넣으면
// 따로 close() 호출하지 않아도 try 블럭을 벗어나는 순간 자동적으로 close() 가 호출된다.
// 다음에 catch 블럭 또는 finally 블럭이 수행된다.