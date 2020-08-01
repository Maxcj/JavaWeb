package cn.maxcj.service;

import cn.maxcj.bean.User;

/**
 * @author maxcj
 */
public interface UserService {

    User login(String email, String password) throws Exception;

}
