package com.springboot.service.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.doctor.DoctorDao;
import com.springboot.service.admin.AdminDeleteService;
import com.springboot.service.doctor.DoctorDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminDeleteServiceImpl implements AdminDeleteService {
    @Autowired
    AdminDao adminDaoImpl;


    @Override
    public int adminDelete(Integer DOCTOR_ID) {
        return adminDaoImpl.adminDelete(DOCTOR_ID);
    }
}
