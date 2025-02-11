package day7.collectionListEx;

import java.util.ArrayList;
import java.util.List;

public class BoardMain {
    public static void main(String[] args) {
        //글을 보관 운영하는 ArrayList 생성
        List<Board> boardList = new ArrayList<Board>();

        //객체(Board) 추가
        boardList.add(new Board("제목1","ssg1","어렵네"));
        boardList.add(new Board("제목2","ssg2","어렵네"));
        boardList.add(new Board("제목3","ssg3","어렵네"));

        //저장된 글 목록 수
        int size = boardList.size();
        System.out.println("총 글의 수:"+size);

        //특정 인덱스의 객체 가져오기
        Board board = boardList.get(1);
        System.out.printf("주제 :%s 내용 : %s 작성자 : %s%n",board.getSubject(),board.getContent(),board.getWriter());

        //글목록
        for(Board board1 : boardList){
            System.out.printf("주제 :%s 내용 : %s 작성자 : %s%n",board1.getSubject(),board1.getContent(),board1.getWriter());
        }
        System.out.println();

        //글삭제
        boardList.remove(2);
        for(Board board2 : boardList){
            System.out.printf("주제 :%s 내용 : %s 작성자 : %s%n",board2.getSubject(),board2.getContent(),board2.getWriter());
        }


    }
}
