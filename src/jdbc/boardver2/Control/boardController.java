package jdbc.boardver2.Control;

import jdbc.boardver2.DBconnetion.DBConnetion;
import jdbc.boardver2.boardDelete;
import jdbc.boardver2.boardInsert;
import jdbc.boardver2.boardSelect;
import jdbc.boardver2.boardUpdate;

import java.sql.Connection;
import java.util.Scanner;

import static jdbc.boardver2.boardenum.*;

public class boardController implements boardControl{

    private Connection connection;
    private boardInsert boardInsert;
    private boardSelect boardSelect;
    private boardDelete boarddelete;
    private boardUpdate boardupdate;


    public boardController() {
        this.connection = DBConnetion.dbconnection();
        this.boardInsert = new boardInsert(connection);
        this.boardSelect = new boardSelect(connection);
        this.boarddelete = new boardDelete(connection);
        this.boardupdate = new boardUpdate(connection);
    }


    @Override
    public void insert() {
        boardInsert.insert();
    }

    @Override
    public void select() {
        boardSelect.select();
    }

    @Override
    public void delete() {
        boarddelete.delete();
    }

    @Override
    public void update() {
        boardupdate.update();
    }

    @Override
    public void start(){
        int choice = 0;

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(boardprogram.getText());
            System.out.println(controlline.getText());
            System.out.println(controlchoice.getText());
            System.out.printf(controlinput.getText());
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    select();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println(systemexit.getText());
                    System.exit(0);
                case 6:
                    connection = DBConnetion.userchange();
                default:
                    break;
            }
        }
    }
}
