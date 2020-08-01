package cn.maxcj.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author maxcj
 */
public interface CallBack {

    Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs);

}
