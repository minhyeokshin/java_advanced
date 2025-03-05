package jdbc.callablestmt;

import jdbc.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CallableStatEx04 {

    Connection conn = null;
    CallableStatement cs = null;

    public CallableStatEx04() throws SQLException{
        conn = DBUTIL.getConnection();
        conn.setAutoCommit(false);

        cs = conn.prepareCall("call SP_MEMBER_LIST()");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            jdbc.callablestmt.SpDTO spDTO = new SpDTO();
            spDTO.setM_seq(rs.getInt(1));
            spDTO.setM_userid(rs.getString(2));
            spDTO.setM_pwd(rs.getString(3));
            spDTO.setM_email(rs.getString(4));
            spDTO.setM_hp(rs.getString(5));
            spDTO.setM_registdate(rs.getString(6));
            spDTO.setM_point(rs.getInt(7));

            System.out.println(spDTO);
        }

        if (cs != null) cs.close();
        if (conn != null) conn.close();

    }

    public static void main(String[] args) throws SQLException {
        new CallableStatEx04();
    }
}