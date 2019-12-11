package com.springboot.service.user;

import com.springboot.domain.Admin;
import com.springboot.domain.Reply;
import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserLoginAuthService {

    /**
     * 登录验证
     * @return boolean
     * */
    boolean userLoginAuth(User login);
}
