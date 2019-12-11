package com.springboot.service.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reportform.ReportFormDeleteService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormDeleteServiceImpl implements ReportFormDeleteService {
    @Autowired
    ReportFormDao reportFormDao;

    @Override
    public int reportFormDelete(Integer REPORTFORM_ID) {
        return reportFormDao.ReportFormDelete(REPORTFORM_ID);
    }
}
