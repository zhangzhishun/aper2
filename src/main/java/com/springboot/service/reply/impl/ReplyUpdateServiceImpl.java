package com.springboot.service.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;
import com.springboot.service.reply.ReplyUpdateService;
import com.springboot.service.reportform.ReportFormUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReplyUpdateServiceImpl implements ReplyUpdateService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public int updateReply(Reply reply) {
        return replyDao.replyUpdate(reply);
    }
}
