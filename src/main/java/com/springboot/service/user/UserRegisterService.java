package com.springboot.service.user;

import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserRegisterService {
    /**
     * 用户注册
     * @return int
     * */
    int userRegister(User user);

    /**
     * 检查用户名是否可用
     * @return int
     * */
    int checkName(String USER_NAME);

}
