package com.springboot.service.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.domain.Admin;
import com.springboot.service.admin.AdminLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminLoginAuthServiceImpl implements AdminLoginAuthService {
    @Autowired
    AdminDao adminDaoImpl;
    @Override
    public boolean adminLoginAuth(Admin login) {
        boolean result = false;
        //System.out.println("Service" + login.getADMIN_NAME());
        Admin adminInSql = adminDaoImpl.getAdminByName(login.getADMIN_NAME());
        if(adminInSql != null && adminInSql.getADMIN_PASSWORD().equals(login.getADMIN_PASSWORD())){
            result = true;
        }
        return result;
    }
}
