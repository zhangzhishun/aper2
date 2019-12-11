package com.springboot.service.admin;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminRegisterService {
    /**
     * 用户注册
     * @return int
     * */
    int adminRegister(Admin admin);

    /**
     * 检查用户名是否可用
     * @return int
     * */
    int checkName(String ADMIN_NAME);

}
