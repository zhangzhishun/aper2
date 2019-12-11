package com.springboot.service.office.impl;

import com.springboot.dao.office.OfficeDao;
import com.springboot.service.office.OfficeDeleteService;
import com.springboot.service.office.OfficeGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class OfficeDeleteServiceImpl implements OfficeDeleteService {
    @Autowired
    OfficeDao officeDaoImpl;

    @Override
    public int officeDelete(Integer OFFICE_ID) {
        return officeDaoImpl.officeDelete(OFFICE_ID);
    }
}
