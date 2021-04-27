package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.Beanid;
import DBUitl.DBUtil;

public class Dao {
    //
    
        
        
        public static boolean id(String id,String pwd) {
            boolean f = false;
            String sql = "select * from denglu where idc = '" + id + "' and password = '"+ pwd +"'";
            //
            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;       
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                if (rs.next()) {
                    f = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs, state, conn);
            }
            return f;
        }
}