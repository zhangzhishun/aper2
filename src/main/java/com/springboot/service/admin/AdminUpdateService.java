package com.springboot.service.admin;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminUpdateService {
    /**
     * 用户更新数据
     * @return int
     * */
    int adminUpdate(Admin admin);

}
