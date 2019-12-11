package com.springboot.service.reportform;

import com.springboot.domain.ReportForm;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormGetService {

    /**
     * 获取ReportForm中所有数据
     * @return boolean*/
    List<Map<String,Object>> getReportForm();

    /**
     * 根据REPORTFORM_ID获取一条数据
     * @return boolean*/
    List<Map<String,Object>> getReportFormByREPORTFORM_ID(Integer REPORTFORM_ID);

    /**
     * 根据REPORTFORM_ID获取一条数据
     * @return boolean*/
    List<Map<String,Object>> getGetUnHandleReportFormByDOCTORID(Integer DOCTOR_ID);

}
