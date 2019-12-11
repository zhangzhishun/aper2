package com.springboot.service.doctor.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.service.doctor.DoctorLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class DoctorLoginAuthServiceImpl implements DoctorLoginAuthService {
    @Autowired
    DoctorDao doctorDaoImpl;
    @Override
    public boolean doctorLoginAuth(Doctor login) {
        boolean result = false;
        Doctor doctorInSql = doctorDaoImpl.getDoctorByName(login.getDOCTOR_NAME());
        if(doctorInSql != null && doctorInSql.getDOCTOR_PASSWORD().equals(login.getDOCTOR_PASSWORD())){
            result = true;
        }
        return result;
    }
}
