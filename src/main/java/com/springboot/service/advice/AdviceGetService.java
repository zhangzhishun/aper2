package com.springboot.service.advice;

import com.springboot.domain.Advice;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdviceGetService {

    /**
     * 获取用户指定一个回复
     * @return Reply*/
    List<Map<String, Object>> getAdviceByADVICEID(String ADVICE_ID);

    /**
     * 获取用户指定一个回复
     * @return Reply*/
    List<Map<String, Object>> getAllAdvice();

}
