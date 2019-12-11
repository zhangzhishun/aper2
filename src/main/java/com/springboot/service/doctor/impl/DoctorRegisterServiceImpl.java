package com.springboot.service.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.dao.user.UserDao;
import com.springboot.domain.Doctor;
import com.springboot.domain.User;
import com.springboot.service.doctor.DoctorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class DoctorRegisterServiceImpl implements DoctorRegisterService {
    @Autowired
    DoctorDao doctorDaoImpl;

    @Override
    public int doctorRegister(Doctor doctor) {
        if(doctorDaoImpl.getDoctorByName(doctor.getDOCTOR_NAME())==null){
            int result = doctorDaoImpl.doctorRegister(doctor);
            return result;
        }else{
            return -1;
        }
    }

    @Override
    public int checkName(String DOCTOR_NAME) {
        if(doctorDaoImpl.getDoctorByName(DOCTOR_NAME)==null){
            return 1;
        }else{
            return 0;
        }
    }
}
