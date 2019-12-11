package com.springboot.service.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Doctor;
import com.springboot.service.doctor.DoctorUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class DoctorUpdateServiceImpl implements DoctorUpdateService {
    @Autowired
    DoctorDao doctorDaoImpl;

    @Override
    public int doctorUpdate(Doctor doctor) {
        int result = doctorDaoImpl.doctorUpdate(doctor);
        return result;
    }
}
