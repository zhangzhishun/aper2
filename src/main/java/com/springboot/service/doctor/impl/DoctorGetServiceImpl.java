package com.springboot.service.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Doctor;
import com.springboot.service.doctor.DoctorGetService;
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
public class DoctorGetServiceImpl implements DoctorGetService {
    @Autowired
    DoctorDao doctorDaoImpl;

    @Override
    public List<Map<String, Object>> getAllDoctor() {
        return doctorDaoImpl.getAllDoctor();
    }

    @Override
    public List<Map<String, Object>> getDoctorById(Integer DOCTOR_ID) {
        return doctorDaoImpl.getDoctorById(DOCTOR_ID);
    }

    @Override
    public Doctor getDoctorByDOCTORNAME(String DCOTOR_NAME) {
        return doctorDaoImpl.getDoctorByName(DCOTOR_NAME);
    }
}
