package cn.maxcj.dao;

import cn.maxcj.bean.User;
import cn.maxcj.common.DeletedStatus;
import cn.maxcj.dao.base.BaseDAO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author maxcj
 */
public class UserDAO extends BaseDAO {


    public Integer addUser(User user) {
        String sql = "insert into t_user (name, sex, age, email, password, status, deleted, create_time, create_by, update_time, update_by)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{user.getName(), user.getSex(), user.getAge(), user.getEmail(), user.getPhone(), user.getPassword(), user.getStatus(),
                DeletedStatus.NO, user.getCreateTime(), user.getCreateBy(), user.getUpdateTime(), user.getUpdateBy()};
        return super.executeInsertTemplate(sql, User.class, param);
    }

    public Integer deleteUser(User user) {
        String sql = "update t_user set deleted = ?, update_by = ?, update_time = ? where id = ?";
        Object[] param = new Object[]{DeletedStatus.YES, user.getUpdateBy(), user.getUpdateTime(), user.getId()};
        return super.executeUpdateTemplate(sql, User.class, param);
    }

    public Integer updateUser(User user) {
        String sql = "update t_user set " + (StringUtils.isBlank(user.getName()) ? "" : "name = ?, ") + (Objects.isNull(user.getSex()) ? "" : "sex = ?, ")
                + (Objects.isNull(user.getAge()) ? "" : "age = ?, ") + (StringUtils.isBlank(user.getEmail()) ? "" : "email = ?, ")
                + (StringUtils.isBlank(user.getPhone()) ? "" : "phone = ?, ") + (StringUtils.isBlank(user.getPassword()) ? "" : "password = ?, ")
                + (Objects.isNull(user.getStatus()) ? "" : "status = ?, ") + "update_by = ?, update_time = ? where id = ?";
        Object[] param = new Object[]{user.getName(), user.getSex(), user.getAge(), user.getEmail(), user.getPhone(), user.getPassword(), user.getStatus(),
                user.getUpdateTime(), user.getUpdateBy(), user.getId()};
        return super.executeUpdateTemplate(sql, User.class, param);
    }


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

    public List<User> getUserList(Integer status) {
        String sql = "select * from t_user where status = ? and deleted = 0";
        Object[] param = new Object[]{status};
        return (List<User>) super.selectListTemplate(sql, User.class, param);
    }


}
