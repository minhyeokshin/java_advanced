package jdbc.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatEx03 {

    Connection conn = null;
    CallableStatement cs = null;

    public CallableStatEx03() throws SQLException{
        conn = DBUTIL.getConnection();
        conn.setAutoCommit(false);

        cs = conn.prepareCall("{call p_insertcodes3(?,?,?,?,?)}");
        // 3. 바인드 변수에 값을 셋팅 inprarmenter (?) 에 값 넣기

        cs.setString(1,"USERID5");
        cs.setString(2,"PW5");
        cs.setString(3,"EMAIL@EMAIL");
        cs.setString(4,"HP");

        cs.registerOutParameter(5,java.sql.Types.VARCHAR);

        // 5. 쿼리 수행
        // flag의 값은 resultSet 객체의 경우는 true , 갱신카운트 또는 결과가 없는 false 리턴
        boolean flag = cs.execute();
        System.out.println(flag);
        String resultMsg = cs.getString(5);
        System.out.println(resultMsg);

        if (cs != null) cs.close();
        if (conn != null) conn.close();

    }

    public static void main(String[] args) throws SQLException {
        new CallableStatEx03();
    }
}