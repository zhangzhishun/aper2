package com.springboot.dao.advice;

import com.springboot.domain.Advice;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdviceDao {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int insertAdvice(Advice advice);

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int deleteAdvice(Integer ADVICE_ID);

    /**
     * 获取用户指定一个回复
     * @return Reply*/
    List<Map<String, Object>> getAdviceByADVICEID(String ADVICE_ID);

    /**
     * 获取用户指定一个回复
     * @return Reply*/
    List<Map<String, Object>> getAllAdvice();
}
