package com.springboot.service.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.service.reply.ReplyGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReplyGetServiceImpl implements ReplyGetService {
    @Autowired
    ReplyDao replyDaoImpl;

    @Override
    public List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME) {
        return replyDaoImpl.getReplyByUSERNAME(USER_NAME);
    }

    @Override
    public List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID) {
        List<Map<String, Object>> result=  replyDaoImpl.getReplyByREPLYID(REPLY_ID);
        return result;
    }

    @Override
    public List<Map<String, Object>> getAllReply() {
        return replyDaoImpl.getReply();
    }
}
