package com.springboot.service.user;

import com.springboot.domain.Advice;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserSubmitAdviceService {
    /**
     * 用户提建议
     * @return boolean
     * */
    Integer insertADVICE(Advice advice);

}
