package jdbc.callablestmt;

import lombok.Data;

@Data
public class SpDTO {
    private int m_seq;
    private String m_userid;
    private String m_pwd;
    private String m_email;
    private String m_hp;
    private String m_registdate;
    private int m_point;

    @Override
    public String toString() {
        return "SpDTO{" +
                "\t\t" + m_seq +
                "\t\t" + m_userid + '\'' +
                "\t\t" + m_pwd + '\'' +
                "\t\t" + m_email + '\'' +
                "\t\t" + m_hp + '\'' +
                "\t\t" + m_registdate + '\'' +
                "\t\t" + m_point +
                '}';
    }
}
