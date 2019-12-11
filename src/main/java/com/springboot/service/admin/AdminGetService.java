package com.springboot.service.admin;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminGetService {

    /**
     * 根据USER_NAME获取USER_ID
     * @return Integer
     * */
    Admin getAdminByADMINID(Integer USER_ID);

    /**
     * 登录验证
     * @return List<Map<String,Object>>
     * */
    List<Map<String,Object>> getAllAdmin();

    /**
     * 根据USER_ID获取USER
     * @return List<Map<String,Object>>
     * */
    Admin getAdminByADMINNAME(String ADMIN_NAME);
}
