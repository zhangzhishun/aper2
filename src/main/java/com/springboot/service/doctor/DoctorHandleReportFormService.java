package com.springboot.service.doctor;

import com.springboot.domain.Doctor;
import com.springboot.domain.Reply;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorHandleReportFormService {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getGetReportFormByDOCTORID(Integer DOCTOR_ID);

    /**
     * 根据医生ID获取Reply
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getGetReplyByDOCTORID(Integer DOCTOR_ID);

    /**
     * 医生回复
     * @return int
     * */
    int doctorUpdateReply(Reply reply);

}
