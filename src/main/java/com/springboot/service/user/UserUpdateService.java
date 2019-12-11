package com.springboot.service.user;

import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserUpdateService {
    /**
     * 用户更新数据
     * @return int
     * */
    int userUpdate(User user);

}
