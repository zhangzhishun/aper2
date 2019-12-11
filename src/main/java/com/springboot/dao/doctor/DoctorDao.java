package com.springboot.dao.doctor;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Doctor
     */
    Doctor getDoctorByName(String DOCTOR_NAME);

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDoctorById(Integer DOCTOR_ID);


    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Doctor
     */
    List<Map<String, Object>> getAllDoctor();

    /**
     * 删除
     * @return Doctor
     */
    int doctorDelete(Integer DOCTOR_ID);

    /**
     * 注册
     * @return int
     */
    int doctorRegister(Doctor doctor);

    /**
     * 更新
     * @return int
     */
    int doctorUpdate(Doctor dcotor);

}
