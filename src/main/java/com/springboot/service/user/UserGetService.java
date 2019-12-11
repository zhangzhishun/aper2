package com.springboot.service.user;

import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserGetService {
    /**
     * 根据USER_NAME获取USER_ID
     * @return Integer
     * */
    Integer getIdByName(String USER_NAME);

    /**
     * 根据USER_NAME获取USE对象
     * @return User
     * */
    User getUserByName(String USER_NAME);

    /**
     * 根据USER_ID获取USER
     * @return List<Map<String,Object>>
     * */
    Map<String,Object> getUserByUSERID(String USER_ID);

    /**
     * 获取所有USE对象
     * @return List<Map<String,Object>>
     * */
    List<Map<String,Object>> getUser();

}
