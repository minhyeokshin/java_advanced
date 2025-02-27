package jdbc.boardver2.Control;

import jdbc.boardver2.DBconnetion.DBConnetion;
import jdbc.boardver2.boardDelete;
import jdbc.boardver2.boardInsert;
import jdbc.boardver2.boardSelect;
import jdbc.boardver2.boardUpdate;

import java.sql.Connection;
import java.util.Scanner;

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
            System.out.println("게시파 프로그램");
            System.out.println("====================================");
            System.out.println("1.입력\t2.검색\t3.수정\t4.삭제\t5.종료");
            System.out.printf("입력 : ");
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
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
