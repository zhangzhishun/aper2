package com.springboot.service.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.service.admin.AdminUpdateService;
import com.springboot.service.doctor.DoctorUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminUpdateServiceImpl implements AdminUpdateService {
    @Autowired
    AdminDao adminDaoImpl;

    @Override
    public int adminUpdate(Admin admin) {
        int result = adminDaoImpl.adminUpdate(admin);
        return result;
    }
}
