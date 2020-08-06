package cn.maxcj.service.impl;

import cn.maxcj.bean.User;
import cn.maxcj.core.BusinessException;
import cn.maxcj.dao.UserDAO;
import cn.maxcj.service.UserService;
import cn.maxcj.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

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

}
