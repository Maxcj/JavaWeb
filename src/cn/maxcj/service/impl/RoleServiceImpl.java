package cn.maxcj.service.impl;

import cn.maxcj.bean.Role;
import cn.maxcj.bean.UserRole;
import cn.maxcj.bean.system.RuntimeUser;
import cn.maxcj.core.BusinessException;
import cn.maxcj.dao.RoleDAO;
import cn.maxcj.dao.UserRoleDAO;
import cn.maxcj.service.RoleService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author maxcj
 */
public class RoleServiceImpl implements RoleService {

    private static RoleDAO roleDAO = new RoleDAO();

    private static UserRoleDAO userRoleDAO = new UserRoleDAO();

    @Override
    public void createRole(Integer roleCode, String roleName, String desc, RuntimeUser runtimeUser) throws BusinessException {
        Role role = new Role();
        role.setRoleCode(roleCode);
        role.setRoleName(roleName);
        role.setDesc(desc);
        Date now = new Date();
        role.setCreateTime(now);
        role.setUpdateTime(now);
        role.setCreateBy(runtimeUser.getEmail());
        role.setUpdateBy(runtimeUser.getEmail());
        Integer count = roleDAO.addRole(role);
        if (count <= 0) {
            throw new BusinessException("add role error");
        }
    }

    @Override
    public void deleteRole(Integer roleId, RuntimeUser runtimeUser) throws BusinessException {
        List<UserRole> userRoleList = userRoleDAO.getUserRoleListByRoleId(roleId);
        if (!userRoleList.isEmpty()) {
            throw new BusinessException("There are users under this role.");
        }
        Role role = new Role();
        role.setId(roleId);
        role.setUpdateBy(runtimeUser.getEmail());
        role.setUpdateTime(new Date());
        Integer count = roleDAO.deleteRole(role);
        if (count <= 0) {
            throw new BusinessException("add role error");
        }
    }

    @Override
    public void updateRole(Integer roleId, String roleName, String desc, RuntimeUser runtimeUser) throws BusinessException {
        Role role = new Role();
        role.setId(roleId);
        role.setRoleName(roleName);
        role.setDesc(desc);
        role.setUpdateBy(runtimeUser.getEmail());
        role.setUpdateTime(new Date());
        Integer count = roleDAO.updateRoleInfo(role);
        if (count <= 0) {
            throw new BusinessException("update role info error");
        }
    }

    @Override
    public List<Role> getRoleList(String roleName) {
        List<Role> roleList = roleDAO.getRoleList(roleName);
        if (roleList.isEmpty()) {
            return Collections.emptyList();
        }
        return roleList;
    }


}
