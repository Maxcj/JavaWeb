package cn.maxcj.dao;

import cn.maxcj.bean.User;
import cn.maxcj.dao.base.BaseDAO;

/**
 * @author maxcj
 */
public class UserDAO extends BaseDAO {

    public User getUserByEmail(String email) {
        String sql = "select * from t_user where email = ? and deleted = 0";
        Object[] param = new Object[]{email};
        return (User) super.selectObjectTemplate(sql, User.class, param);
    }

    public User getUserByUserId(Integer userId) {
        String sql = "select * from t_user where id = ? and deleted = 0";
        Object[] param = new Object[]{userId};
        return (User) super.selectObjectTemplate(sql, User.class, param);
    }


}
