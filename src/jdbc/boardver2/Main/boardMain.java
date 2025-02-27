package jdbc.boardver2.Main;

import jdbc.boardver2.Control.boardControl;
import jdbc.boardver2.Control.boardController;

import java.nio.charset.StandardCharsets;

public class boardMain {
    public static void main(String[] args) {

        boardControl control = new boardController();
        control.start();
    }
}
