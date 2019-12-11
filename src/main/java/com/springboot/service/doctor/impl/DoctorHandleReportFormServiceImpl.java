package com.springboot.service.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.Doctor;
import com.springboot.domain.Reply;
import com.springboot.service.doctor.DoctorHandleReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class DoctorHandleReportFormServiceImpl implements DoctorHandleReportFormService {
    @Autowired
    DoctorDao doctorDaoImpl;

    @Autowired
    ReplyDao replyDaoImpl;

    @Autowired
    ReportFormDao reportFormDaoImpl;

    @Override
    public List<Map<String, Object>> getGetReportFormByDOCTORID(Integer DOCTOR_ID) {
        return reportFormDaoImpl.getGetReportFormByDOCTORID(DOCTOR_ID);
    }

    @Override
    public List<Map<String, Object>> getGetReplyByDOCTORID(Integer DOCTOR_ID) {
        return replyDaoImpl.getGetReplyByDOCTORID(DOCTOR_ID);
    }

    @Override
    public int doctorUpdateReply(Reply reply) {
        return replyDaoImpl.replyUpdate(reply);
    }
}
