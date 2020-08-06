package cn.maxcj.dao;

import cn.maxcj.bean.UserRole;
import cn.maxcj.common.DeletedStatus;
import cn.maxcj.dao.base.BaseDAO;

import java.util.List;

/**
 * @author maxcj
 */
public class UserRoleDAO extends BaseDAO {

    public Integer addRole4User(UserRole userRole) {
        String sql = "insert into t_user_role (role_id, user_id, deleted, create_time, create_by, update_time, update_by) values(?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{userRole.getRoleId(), userRole.getUserId(), DeletedStatus.NO, userRole.getCreateTime(), userRole.getCreateBy(), userRole.getUpdateTime(), userRole.getUpdateBy()};
        return super.executeInsertTemplate(sql, UserRole.class, param);
    }

    public Integer deleteRole4User(UserRole userRole) {
        String sql = "update t_user_role set deleted = ?, update_by = ?, update_time = ? where user_id = ? and role_id = ? and deleted = ?";
        Object[] param = new Object[]{DeletedStatus.YES, userRole.getUpdateBy(), userRole.getUpdateTime(), userRole.getUserId(), userRole.getRoleId(), DeletedStatus.NO};
        return super.executeUpdateTemplate(sql, UserRole.class, param);
    }

    public List<UserRole> getUserRoleListByRoleId(Integer roleId) {
        String selectUserRole = "select * from t_user_role where deleted = 0 and role_id = ?";
        Object[] param = new Object[]{roleId};
        return (List<UserRole>) super.selectListTemplate(selectUserRole, UserRole.class, param);
    }

    public List<UserRole> getUserRoleListByUserId(Integer userId) {
        String selectUserRole = "select * from t_user_role where deleted = 0 and user_id = ?";
        Object[] param = new Object[]{userId};
        return (List<UserRole>) super.selectListTemplate(selectUserRole, UserRole.class, param);
    }


}
