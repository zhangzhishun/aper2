package com.springboot.service.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.domain.User;
import com.springboot.service.admin.AdminGetService;
import com.springboot.service.doctor.DoctorGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminGetServiceImpl implements AdminGetService {
    @Autowired
    AdminDao adminDaoImpl;

    @Override
    public Admin getAdminByADMINID(Integer USER_NAME) {
        Admin userInSql = adminDaoImpl.getAdminById(String.valueOf(USER_NAME));
        return userInSql;
    }

    @Override
    public List<Map<String, Object>> getAllAdmin() {
        return adminDaoImpl.getAllAdmin();
    }

    @Override
    public Admin getAdminByADMINNAME(String DCOTOR_NAME) {
        return adminDaoImpl.getAdminByName(DCOTOR_NAME);
    }
}
