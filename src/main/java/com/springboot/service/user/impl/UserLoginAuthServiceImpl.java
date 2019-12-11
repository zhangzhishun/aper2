package com.springboot.service.user.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.user.UserDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.domain.Reply;
import com.springboot.domain.User;
import com.springboot.service.user.UserLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserLoginAuthServiceImpl implements UserLoginAuthService {
    @Autowired
    UserDao userDaoImpl;
    @Override
    public boolean userLoginAuth(User login) {
        boolean result = false;
        User userInSql = userDaoImpl.getUserByName(login.getUSER_NAME());
        if(userInSql != null && userInSql.getUSER_PASSWORD().equals(login.getUSER_PASSWORD())){
            result = true;
        }
        return result;
    }

}
