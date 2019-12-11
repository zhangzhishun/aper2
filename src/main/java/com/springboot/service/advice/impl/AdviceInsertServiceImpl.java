package com.springboot.service.advice.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.domain.Advice;
import com.springboot.service.advice.AdviceInsertService;
import com.springboot.service.user.UserSubmitAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdviceInsertServiceImpl implements AdviceInsertService {
    @Autowired
    AdviceDao adviceDaoImpl;

    @Override
    public Integer insertAdvice(Advice advice) {
        return adviceDaoImpl.insertAdvice(advice);
    }

}
