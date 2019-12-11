package com.springboot.service.reply;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReplyDeleteService {

    /**
     * 根据REPLY_ID删除一个reply
     * @return int
     * */
    int replyDelete(Integer REPLY_ID);

}
