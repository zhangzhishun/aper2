package com.springboot.service.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reply.ReplyInsertService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReplyInsertServiceImpl implements ReplyInsertService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public int insertReply(Reply reply) {
        return replyDao.replyInsert(reply);
    }
}
