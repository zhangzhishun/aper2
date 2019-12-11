package com.springboot.service.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.service.admin.AdminRegisterService;
import com.springboot.service.doctor.DoctorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminRegisterServiceImpl implements AdminRegisterService {
    @Autowired
    AdminDao adminDaoImpl;

    @Override
    public int adminRegister(Admin admin) {
        if(adminDaoImpl.getAdminByName(admin.getADMIN_NAME())==null){
            int result = adminDaoImpl.adminRegister(admin);
            return result;
        }else{
            return -1;
        }
    }

    @Override
    public int checkName(String DOCTOR_NAME) {
        if(adminDaoImpl.getAdminByName(DOCTOR_NAME)==null){
            return 1;
        }else{
            return 0;
        }
    }
}
