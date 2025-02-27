package jdbc.boardver2.main;

import jdbc.boardver2.control.boardControl;
import jdbc.boardver2.control.boardController;

public class boardMain {
    public static void main(String[] args) {

        boardControl control = new boardController();
        control.start();
    }
}
