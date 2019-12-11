package com.springboot.dao.reply;

import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;
import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReplyDao {

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME);

    /**
     * 根据医生ID获取Reply
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getGetReplyByDOCTORID(Integer DOCTOR_ID);

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReplyAndUserByREPLYID(String REPLY_ID);

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID);

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    Integer updateReplyState(String REPLY_ID,Integer newState);


    /**
     * 获取用户提交的所有信息 包括用户信息和提交信息
     * @return boolean*/
    List<Map<String,Object>> getReply();

    /**
     * 更新
     * @return int
     */
    int replyUpdate(Reply reply);

    /**
     * 删除用户
     * @return int
     */
    int replyDelete(Integer REPLY_ID);

    /**
     * 用户注册
     * @return int
     */
    int replyInsert(Reply reply);
}
