package com.springboot.service.user.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserGetServiceImpl implements UserGetService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public Integer getIdByName(String USER_NAME) {
        User userInSql = userDaoImpl.getUserByName(USER_NAME);
        return userInSql.getUSER_ID();
    }

    @Override
    public User getUserByName(String USER_NAME) {
        User userInSql = userDaoImpl.getUserByName(USER_NAME);
        return userInSql;
    }

    @Override
    public Map<String,Object> getUserByUSERID(String USER_ID) {
        List<Map<String,Object>> userInSql = userDaoImpl.getUser();
        Map<String,Object> result = null;
        for (Map<String,Object> user:userInSql
             ) {
            if(String.valueOf(user.get("USER_ID")).equals(USER_ID)){
                result = user;
            }
        }
        return result;
    }

    @Override
    public List<Map<String,Object>> getUser() {
        List<Map<String,Object>> userInSql = userDaoImpl.getUser();
        return userInSql;
    }
}
