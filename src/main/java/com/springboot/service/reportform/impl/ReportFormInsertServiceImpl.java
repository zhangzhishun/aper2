package com.springboot.service.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormInsertServiceImpl implements ReportFormInsertService {
    @Autowired
    ReportFormDao reportFormDao;

    @Autowired
    UserGetService userGetServiceImpl;

    @Autowired
    OfficeGetService officeGetServiceImpl;
    @Override
    public boolean insertReportForm(ReportForm reportForm) {
        reportFormDao.reportFormAdd(reportForm);
        return true;
    }
}
