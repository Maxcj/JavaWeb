package cn.maxcj.service;

import cn.maxcj.bean.UserRole;
import cn.maxcj.bean.system.RuntimeUser;
import cn.maxcj.core.BusinessException;

import java.util.List;

/**
 * @author maxcj
 */
public interface UserRoleService {

    List<UserRole> getUserRole(Integer userId);

    void addRole4User(Integer userId, Integer roleId, RuntimeUser runtimeUser) throws BusinessException;

    void deleteRole4User(Integer userId, Integer roleId, RuntimeUser runtimeUser) throws BusinessException;

}
