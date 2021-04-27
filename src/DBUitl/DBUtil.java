package DBUitl;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBUtil {
     
    public static String db_url = "jdbc:mysql://localhost:3306/xuan_ke?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone = GMT&allowPublicKeyRetrieval=true";
    public static String db_user = "root";
    public static String db_pass = "15531238359";
     
    public static Connection getConn () {
        Connection conn = null;
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return conn;
    }
     
    /*10鍏抽棴杩炴帴*/
    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     
    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) throws SQLException {
    }
}