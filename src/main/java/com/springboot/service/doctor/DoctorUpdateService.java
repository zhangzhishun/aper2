package com.springboot.service.doctor;

import com.springboot.domain.Doctor;
import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorUpdateService {
    /**
     * 用户更新数据
     * @return int
     * */
    int doctorUpdate(Doctor doctor);

}
