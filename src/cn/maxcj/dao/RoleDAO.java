package cn.maxcj.dao;

import cn.maxcj.bean.Role;
import cn.maxcj.common.DeletedStatus;
import cn.maxcj.dao.base.BaseDAO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author maxcj
 */
public class RoleDAO extends BaseDAO {

    public Integer addRole(Role role) {
        String sql = "insert into t_role (role_code, role_name, desc, deleted, create_time, create_by, update_time, update_by) values(?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{role.getRoleCode(), role.getRoleName(), role.getDesc(), DeletedStatus.NO, role.getCreateTime(), role.getCreateBy(), role.getUpdateTime(), role.getCreateBy()};
        return super.executeInsertTemplate(sql, Role.class, param);
    }

    public Integer deleteRole(Role role) {
        String sql = "update t_role set deleted = ?, update_by = ?, update_time = ? where id = ?";
        Object[] param = new Object[]{DeletedStatus.YES, role.getUpdateBy(), role.getUpdateTime(), role.getId()};
        return super.executeUpdateTemplate(sql, Role.class, param);
    }

    public Integer updateRoleInfo(Role role) {
        String sql = "update t_role set " + (StringUtils.isBlank(role.getRoleName()) ? "" : "role_name = ?, ") + (StringUtils.isBlank(role.getDesc()) ? "" : "desc = ?, ") + "update_by = ?, update_time = ? where id = ?";
        Object[] param = new Object[]{role.getRoleName(), role.getDesc(), role.getUpdateBy(), role.getUpdateTime(), role.getId()};
        return super.executeUpdateTemplate(sql, Role.class, param);
    }

    public List<Role> getRoleList(String roleName) {
        String sql = "select * from t_role where deleted = 0 " + (StringUtils.isBlank(roleName) ? "" : "and role_name like '%'" + roleName + "'%'") + "order by create_time desc";
        return super.selectListTemplate(sql, Role.class, null);
    }

}
