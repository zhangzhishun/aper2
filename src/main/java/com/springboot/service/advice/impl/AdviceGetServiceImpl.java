package com.springboot.service.advice.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.domain.Advice;
import com.springboot.service.advice.AdviceGetService;
import com.springboot.service.advice.AdviceInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdviceGetServiceImpl implements AdviceGetService {
    @Autowired
    AdviceDao adviceDaoImpl;

    @Override
    public List<Map<String, Object>> getAdviceByADVICEID(String ADVICE_ID) {
        return adviceDaoImpl.getAdviceByADVICEID(ADVICE_ID);
    }

    @Override
    public List<Map<String, Object>> getAllAdvice() {
        return adviceDaoImpl.getAllAdvice();
    }
}
