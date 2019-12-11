package com.springboot.dao.reportform;

import com.springboot.domain.ReportForm;
import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormDao {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int reportFormAdd(ReportForm reportForm);

    /**
     * 获取用户提交的所有信息 包括用户信息和提交信息
     * @return boolean*/
    List<Map<String,Object>> getReportForm();

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReportFormByReportFormID(Integer ReportForm_ID);

    /**
     * 根据医生科室名获取科室的所有咨询
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getGetReportFormByDOCTORID(Integer DOCTOR_ID);

    /**
     * 根据用户名获取用户所有未处理的咨询
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getGetUnHandleReportFormByDOCTORID(Integer DOCTOR_ID);
    /**
     * 用户注册
     * @return int
     */
    int reportFormUpdate(ReportForm reportForm);

    /**
     * 更新reportForm中的状态
     * @return int
     */
    int reportFormUpdateState(Integer REPORTFORM_ID,Integer newState);

    /**
     * 删除用户
     * @return int
     */
    int ReportFormDelete(Integer REPORTFORM_ID);

    /**
     * 根据用户ID寻找用户发起的咨询
     * @return boolean*/
    List<Map<String,Object>> getReportFormByUSERID(Integer USER_ID);


}
