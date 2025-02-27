package jdbc.board;

import lombok.Data;

import java.util.Date;

@Data
public class board {
    int bno;
    String btitle;
    String bcontent;
    String bwriter;
    Date bdate;
    String bfilename;
    String bfiledata;

    @Override
    public String toString() {
        return "board{" + "\n" +
                "bno=" + bno + "\n" +
                "btitle='" + btitle + '\'' + "\n" +
                "bcontent='" + bcontent + '\'' + "\n" +
                "bwriter='" + bwriter + '\'' + "\n" +
                "bdate=" + bdate + "\n" +
                "bfilename='" + bfilename + '\'' + "\n" +
                "bfiledata='" + bfiledata + '\'' + "\n" +
                '}' + "\n";
    }
}
