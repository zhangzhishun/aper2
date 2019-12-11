package com.springboot.service.admin;

import com.springboot.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminLoginAuthService {

    /**
     * 登录验证
     * @return boolean
     * */
    boolean adminLoginAuth(Admin login);
}
