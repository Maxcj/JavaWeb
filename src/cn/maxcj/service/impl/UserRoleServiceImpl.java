package cn.maxcj.service.impl;

import cn.maxcj.bean.UserRole;
import cn.maxcj.bean.system.RuntimeUser;
import cn.maxcj.common.DeletedStatus;
import cn.maxcj.core.BusinessException;
import cn.maxcj.dao.UserRoleDAO;
import cn.maxcj.service.UserRoleService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author maxcj
 */
public class UserRoleServiceImpl implements UserRoleService {

    private static UserRoleDAO userRoleDAO = new UserRoleDAO();

    @Override
    public List<UserRole> getUserRole(Integer userId) {
        List<UserRole> list = userRoleDAO.getUserRoleListByUserId(userId);
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public void addRole4User(Integer userId, Integer roleId, RuntimeUser runtimeUser) throws BusinessException {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        userRole.setDeleted(DeletedStatus.NO);
        userRole.setCreateTime(new Date());
        userRole.setUpdateTime(new Date());
        userRole.setCreateBy(runtimeUser.getEmail());
        userRole.setUpdateBy(runtimeUser.getEmail());
        Integer count = userRoleDAO.addRole4User(userRole);
        if (count <= 0) {
            throw new BusinessException("add role error");
        }
    }

    @Override
    public void deleteRole4User(Integer userId, Integer roleId, RuntimeUser runtimeUser) throws BusinessException {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        userRole.setUpdateTime(new Date());
        userRole.setUpdateBy(runtimeUser.getEmail());
        Integer count = userRoleDAO.deleteRole4User(userRole);
        if (count <= 0) {
            throw new BusinessException("delete role error");
        }
    }
}
