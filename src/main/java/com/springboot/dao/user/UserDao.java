package com.springboot.dao.user;

import com.springboot.domain.Admin;
import com.springboot.domain.Reply;
import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return User
     */
    User getUserByName(String USER_NAME);

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUser();

    /**
     * 用户注册
     * @return int
     */
    int userRegister(User user);

    /**
     * 用户注册
     * @return int
     */
    int userUpdate(User user);

    /**
     * 删除用户
     * @return int
     */
    int deleteUser(Integer USER_ID);

}
