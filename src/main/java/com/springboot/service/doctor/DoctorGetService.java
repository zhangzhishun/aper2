package com.springboot.service.doctor;

import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorGetService {

    /**
     * 登录验证
     * @return List<Map<String,Object>>
     * */
    List<Map<String,Object>> getAllDoctor();

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDoctorById(Integer DOCTOR_ID);

    /**
     * 根据USER_ID获取USER
     * @return List<Map<String,Object>>
     * */
    Doctor getDoctorByDOCTORNAME(String DCOTOR_NAME);
}
