package cn.maxcj.service;

import cn.maxcj.bean.Role;
import cn.maxcj.bean.system.RuntimeUser;
import cn.maxcj.core.BusinessException;

import java.util.List;

/**
 * @author maxcj
 */
public interface RoleService {

    void createRole(Integer roleCode, String roleName, String desc, RuntimeUser runtimeUser) throws BusinessException;

    void deleteRole(Integer roleId, RuntimeUser runtimeUser) throws BusinessException;

    void updateRole(Integer roleId, String roleName, String desc, RuntimeUser runtimeUser) throws BusinessException;

    List<Role> getRoleList(String roleName);

}
