package com.springboot.service.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.service.doctor.DoctorDeleteService;
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
public class DoctorDeleteServiceImpl implements DoctorDeleteService {
    @Autowired
    DoctorDao doctorDaoImpl;


    @Override
    public int doctorDelete(Integer DOCTOR_ID) {
        return doctorDaoImpl.doctorDelete(DOCTOR_ID);
    }
}
