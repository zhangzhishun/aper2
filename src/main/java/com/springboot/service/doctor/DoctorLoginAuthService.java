package com.springboot.service.doctor;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorLoginAuthService {

    /**
     * 登录验证
     * @return boolean
     * */
    boolean doctorLoginAuth(Doctor login);

}
