package com.springboot.service.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.reportform.ReportFormUpdateService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormUpdateServiceImpl implements ReportFormUpdateService {
    @Autowired
    ReportFormDao reportFormDaoImpl;

    @Override
    public int updateReportForm(ReportForm reportForm) {
        return reportFormDaoImpl.reportFormUpdate(reportForm);
    }

    @Override
    public int updateReportFormState(Integer REPORTFORM_ID,Integer newState) {
        return reportFormDaoImpl.reportFormUpdateState(REPORTFORM_ID,newState);
    }
}
