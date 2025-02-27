package jdbc;

public enum Enun {
    INSERT_NAME("이름 입력 : "),
    INSERT_ID("ID 입력 : "),
    INSERT_PW("PW 입력 : ");

    private final String message;

    Enun(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}