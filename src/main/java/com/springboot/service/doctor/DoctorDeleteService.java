package com.springboot.service.doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorDeleteService {

    /**
     * 登录验证
     * @return List<Map<String,Object>>
     * */
    int doctorDelete(Integer DOCTOR_ID);

}
