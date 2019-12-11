package com.springboot.service.advice.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.domain.Advice;
import com.springboot.service.advice.AdviceDeleteService;
import com.springboot.service.advice.AdviceInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdviceDeleteServiceImpl implements AdviceDeleteService {
    @Autowired
    AdviceDao adviceDaoImpl;

    @Override
    public Integer deleteAdvice(Integer ADVICE_ID) {
        return adviceDaoImpl.deleteAdvice(ADVICE_ID);
    }
}
