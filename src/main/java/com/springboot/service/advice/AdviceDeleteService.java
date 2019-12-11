package com.springboot.service.advice;

import com.springboot.domain.Advice;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdviceDeleteService {
    /**
     * 用户提建议
     * @return boolean
     * */
    Integer deleteAdvice(Integer ADVICE_ID);

}
