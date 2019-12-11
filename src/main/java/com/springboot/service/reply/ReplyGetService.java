package com.springboot.service.reply;

import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReplyGetService {

    /**
     * 根据用户名获取给用户的所有回复
     * @return List<Map<String, Object>>*/
    List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME);

    /**
     * 根据REPLY_ID获取一个指定回复
     * @return Reply*/
    List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID);

    /**
     * 获取所有回复
     * @return Reply*/
    List<Map<String, Object>> getAllReply();
}
