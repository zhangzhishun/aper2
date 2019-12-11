package com.springboot.service.user.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
import com.springboot.service.user.UserRegisterService;
import com.springboot.service.user.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public int userUpdate(User user) {
        int result = userDaoImpl.userUpdate(user);
        return result;
    }
}
