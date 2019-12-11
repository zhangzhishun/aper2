package com.springboot.service.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.service.reply.ReplyDeleteService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reportform.ReportFormDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReplyDeleteServiceImpl implements ReplyDeleteService {
    @Autowired
    ReplyDao replyDao;
    @Autowired
    ReplyGetService replyGetServiceImpl;
    @Autowired
    ReportFormDao reportFormDaoImpl;
    @Override
    public int replyDelete(Integer REPLY_ID) {
        List<Map<String ,Object>> reply = replyGetServiceImpl.getReplyByREPLYID(String.valueOf(REPLY_ID));
        for (Map<String ,Object> re:reply
             ) {
            System.out.println("re.get(REPLY_REPOTFORMID" + re.get("REPLY_REPOTFORMID").toString());
            reportFormDaoImpl.reportFormUpdateState(Integer.valueOf(re.get("REPLY_REPOTFORMID").toString()),0);
        }
        return replyDao.replyDelete(REPLY_ID);
    }
}
