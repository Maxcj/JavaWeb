package cn.maxcj.service.impl;

import cn.maxcj.bean.User;
import cn.maxcj.bean.system.RuntimeUser;
import cn.maxcj.common.DeletedStatus;
import cn.maxcj.core.BusinessException;
import cn.maxcj.dao.UserDAO;
import cn.maxcj.service.UserService;
import cn.maxcj.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author maxcj
 */
public class UserServiceImpl implements UserService {

    private static UserDAO userDAO = new UserDAO();

    @Override
    public User login(String email, String password) throws Exception {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            throw new BusinessException("param is invalid.");
        }
        User o = userDAO.getUserByEmail(email);

        if (Objects.isNull(o) || !StringUtils.equals(PasswordUtil.encPassword(password), o.getPassword())) {
            throw new BusinessException("Account & Password is not match.");
        }
        return o;
    }

    @Override
    public Boolean register(String name, String email, String password) throws Exception {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(name)) {
            throw new BusinessException("param is invalid.");
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(PasswordUtil.encPassword(password));
        user.setDeleted(DeletedStatus.NO);
        user.setCreateBy(name);
        user.setUpdateBy(name);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Integer count = userDAO.addUser(user);
        return count > 0;
    }

    @Override
    public Boolean removeUser(Integer userId, RuntimeUser runtimeUser) throws Exception {
        if (Objects.isNull(userId)) {
            throw new BusinessException("param is invalid.");
        }
        User removeUser = new User();
        removeUser.setId(userId);
        removeUser.setUpdateTime(new Date());
        removeUser.setUpdateBy(runtimeUser.getEmail());
        Integer count = userDAO.deleteUser(removeUser);
        return count > 0;
    }

    @Override
    public List<User> listUser(Integer status) {
        List<User> userList = userDAO.getUserList(status);
        if (userList.isEmpty()) {
            return Collections.emptyList();
        }
        return userList;
    }

    @Override
    public User getUser(Integer userId) throws Exception {
        if (Objects.isNull(userId)) {
            throw new BusinessException("param is invalid.");
        }
        return Optional.ofNullable(userDAO.getUserByUserId(userId)).orElseThrow(() -> new BusinessException("user can't find."));
    }

}
