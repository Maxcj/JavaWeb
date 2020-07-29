package cn.maxcj.util;

import cn.maxcj.config.MySQLConfig;
import lombok.experimental.UtilityClass;

import java.sql.*;

/**
 * @author maxcj
 */
@UtilityClass
public class DataBaseUtil {

    static {
        try {
            Class.forName(MySQLConfig.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLConfig.URL, MySQLConfig.USERNAME, MySQLConfig.PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }


    public static void closeJDBC(Connection con, Statement st, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
