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
        String sql = "select * from tb_user where email = ?";
        User o = (User) userDAO.selectObjectTemplate(sql, User.class, new Object[]{email});
        if (Objects.isNull(o)) {
            throw new BusinessException("Account & Password is not match");
        }
        if (StringUtils.equals(PasswordUtil.encPassword(password), o.getPassword())) {
            return o;
        }
        throw new BusinessException("Account & Password is not match");
    }

}
