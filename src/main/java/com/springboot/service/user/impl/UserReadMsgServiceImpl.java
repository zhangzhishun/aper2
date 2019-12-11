package com.springboot.service.user.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
import com.springboot.service.user.UserReadMsgService;
import com.springboot.service.user.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserReadMsgServiceImpl implements UserReadMsgService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public int userReadMsg(String REPLY_ID) {
        int result = replyDao.updateReplyState(REPLY_ID,1);
        return result;
    }
}
