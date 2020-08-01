package cn.maxcj.dao.base;

import cn.maxcj.common.DbOperateType;
import cn.maxcj.util.DataBaseUtil;
import cn.maxcj.util.SqlUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Objects;

/**
 * @author maxcj
 */
public abstract class BaseDAO {

    public Object executeInsertTemplate(String sql, final Class clazz, Object[] params) {
        return executeTemplate(sql, DbOperateType.INSERT, params, clazz, null);
    }

    public Object executeDeleteTemplate(String sql, final Class clazz, Object[] params) {
        return executeTemplate(sql, DbOperateType.DELETE, params, clazz, null);
    }

    public Object executeUpdateTemplate(String sql, final Class clazz, Object[] params) {
        return executeTemplate(sql, DbOperateType.UPDATE, params, clazz, null);
    }

    public Object selectObjectTemplate(String sql, final Class clazz, Object[] params) {
        return executeTemplate(sql, DbOperateType.SELECT, params, clazz, (conn, ps, rs) -> {
            Object obj = null;
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                obj = clazz.newInstance();
                if (rs.next()) {
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnLabel(i + 1);
                        Object columnValue = rs.getObject(i + 1);
                        if (StringUtils.isNotBlank(columnName) && Objects.nonNull(columnValue)) {
                            DataBaseUtil.invokeSet(obj, columnName, columnValue);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        });
    }


    public List selectListTemplate(String sql, final Class clazz, Object[] params) {
        return (List) executeTemplate(sql, DbOperateType.SELECT, params, clazz, (conn, ps, rs) -> {
            List list = Lists.newArrayList();
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                while (rs.next()) {
                    Object obj = clazz.newInstance();
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnLabel(i + 1);
                        Object columnValue = rs.getObject(i + 1);
                        if (StringUtils.isNotBlank(columnName) && Objects.nonNull(columnValue)) {
                            DataBaseUtil.invokeSet(obj, columnName, columnValue);
                        }
                    }
                    list.add(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        });
    }


    private Object executeTemplate(String sql, String operateType, Object[] params, Class clazz, CallBack back) {
        if (!Objects.equals(SqlUtil.countStr(sql, "?"), params.length)) {
            throw new IllegalArgumentException("sql param is invalid");
        }
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            DataBaseUtil.handleParams(ps, params);
            switch (operateType) {
                case DbOperateType.SELECT:
                    rs = ps.executeQuery();
                    return back.doExecute(conn, ps, rs);
                case DbOperateType.INSERT:
                case DbOperateType.DELETE:
                case DbOperateType.UPDATE:
                    return ps.executeUpdate();
                default:
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DataBaseUtil.closeJDBC(conn, ps, rs);
        }
    }

}
