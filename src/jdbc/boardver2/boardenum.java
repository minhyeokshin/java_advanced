package jdbc.boardver2;


public enum boardenum {
    deleteboard("삭제할 게시판 번호 입력 : "),
    inserttile("제목 입력 : "),
    insertcontent("내용 입력 : "),
    insertwriter("작성자 입력 : "),
    insertfilename("이미지 파일 명 입력 : "),
    insertfileinputex("입력 예시 : src/jdbc/image"),
    insertfileinput("이미지 경로 입력 : "),
    selectchoice("1. 전체 검색\t2.선택 검색"),
    selectinput("입력 : "),
    selectbno("검색할 글의 번호를 입력하세요 : "),
    selecterror("없는 글입니다."),
    choiceerror("선택 오류 프로그램을 종료합니다."),
    updatebno("바꿀 게시판 번호 입력 : "),
    updatecontent("게시판 내용 변경 : "),
    runboard("게시판 프로그램을 실행합니다."),
    login("로그인을 합니다."),
    inputid("ID 입력 : "),
    inputpw("PW 입력 : "),
    changelogin("로그인 정보를 변경합니다."),
    loginerror("로그인 정보가 올바르지 않습니다."),
    systemexit("프로그랩을 종료합니다."),
    boardprogram("게시판 프로그램"),
    controlline("===================================="),
    controlchoice("1.입력\t2.검색\t3.수정\t4.삭제\t5.종료\t6.사용자변경(재 로그인)"),
    controlinput("입력 : ");

    private final String message;


    boardenum(String message) {
        this.message = message;
    }


    public String getText() {
        return message;
    }
}
