package day2.exception.ex02.resourceEx;

import java.io.FileWriter;
import java.io.IOException;

public class FileEx {
    public static void main(String[] args) throws IOException {
        FileWriter file = null;

        try {
            file = new FileWriter("data.txt");
            file.write("Java Advanced Programming2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file.close();
        }
    }
}
