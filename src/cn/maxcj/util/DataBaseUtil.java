package cn.maxcj.util;

import cn.maxcj.core.config.MySQLConfig;

import java.lang.reflect.Method;
import java.sql.*;

/**
 * @author maxcj
 */
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

    public static void handleParams(PreparedStatement ps, Object[] params) {
        try {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokeSet(Object obj, String columnName, Object columnValue) {
        try {
            Class<?> clazz = columnValue.getClass();
            if (columnValue instanceof java.sql.Timestamp) {
                clazz = java.util.Date.class;
            }
            Method m = obj.getClass().getDeclaredMethod("set" + char2UpperCase(columnName), clazz);
            m.invoke(obj, columnValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String char2UpperCase(String str) {
        return str.toUpperCase().substring(0, 1) + ColumnUtil.lineToHump(str.substring(1));
    }

}
