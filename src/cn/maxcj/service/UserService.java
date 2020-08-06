package cn.maxcj.service;

import cn.maxcj.bean.User;
import cn.maxcj.bean.system.RuntimeUser;

import java.util.List;

/**
 * @author maxcj
 */
public interface UserService {

    User login(String email, String password) throws Exception;

    Boolean register(String name, String email, String password) throws Exception;

    List<User> listUser(Integer status);

    User getUser(Integer userId) throws Exception;

    Boolean removeUser(Integer userId, RuntimeUser runtimeUser) throws Exception;

}
