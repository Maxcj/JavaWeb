package cn.maxcj.dao;

import cn.maxcj.bean.UserRole;
import cn.maxcj.dao.base.BaseDAO;

import java.util.List;

/**
 * @author maxcj
 */
public class UserRoleDAO extends BaseDAO {


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
