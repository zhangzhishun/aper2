package com.springboot.service.user.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.dao.user.UserDao;
import com.springboot.service.reportform.ReportFormGetService;
import com.springboot.service.user.UserDeleteService;
import com.springboot.service.user.UserGetMyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserGetMyReportServiceImpl implements UserGetMyReportService {

    @Autowired
    ReportFormDao reportFormDaoImpl;

    @Override
    public List<Map<String, Object>> UserGetMyReportByUSERID(Integer USER_ID) {
        return reportFormDaoImpl.getReportFormByUSERID(USER_ID);
    }
}
