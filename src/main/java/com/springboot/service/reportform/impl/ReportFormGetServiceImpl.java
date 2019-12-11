package com.springboot.service.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reportform.ReportFormGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormGetServiceImpl implements ReportFormGetService {
    @Autowired
    ReportFormDao reportFormDaoImpl;


    @Override
    public List<Map<String, Object>> getReportForm() {
        return reportFormDaoImpl.getReportForm();
    }

    @Override
    public List<Map<String, Object>> getReportFormByREPORTFORM_ID(Integer REPORTFORM_ID) {
        return reportFormDaoImpl.getReportFormByReportFormID(REPORTFORM_ID);
    }

    @Override
    public List<Map<String, Object>> getGetUnHandleReportFormByDOCTORID(Integer DOCTOR_ID) {
        return reportFormDaoImpl.getGetUnHandleReportFormByDOCTORID(DOCTOR_ID);
    }
}
