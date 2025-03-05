package jdbc.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatEx01 {

    Connection conn = null;
    CallableStatement cs = null;

    public CallableStatEx01() throws SQLException {
        // 1. Connection 얻어오기
        conn = DBUTIL.getConnection();
        // 2. CallableStatement 객체를 이용하여 호출할 프로시저 연결
        cs = conn.prepareCall("{call p_insertcodes(?,?,?)}");
        // 3. 바인드 변수에 값을 셋팅 inprarmenter (?) 에 값 넣기

        cs.setString(1,"프론트 고급 개발자3"); //코드네임
        cs.setString(2,"CODE1");

        // 4. Out 파라미터에 저장된 프로시저의 수행결과 출력

        cs.registerOutParameter(3,java.sql.Types.VARCHAR);

        // 5. 쿼리 수행
        // flag의 값은 resultSet 객체의 경우는 true , 갱신카운트 또는 결과가 없는 false 리턴
        boolean flag = cs.execute();
        System.out.println(flag);
        String resultMsg = cs.getString(3);
        System.out.println(resultMsg);

        if (cs != null) cs.close();
        if (conn != null) conn.close();

    }

    public static void main(String[] args) throws SQLException {
        new CallableStatEx01();
    }
}

