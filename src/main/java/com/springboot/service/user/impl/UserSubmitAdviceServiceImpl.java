package com.springboot.service.user.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.dao.user.UserDao;
import com.springboot.domain.Advice;
import com.springboot.service.user.UserSubmitAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserSubmitAdviceServiceImpl implements UserSubmitAdviceService {
    @Autowired
    AdviceDao adviceDaoImpl;


    @Override
    public Integer insertADVICE(Advice advice) {
        return adviceDaoImpl.insertAdvice(advice);
    }
}
