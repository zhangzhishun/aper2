package com.springboot.service.office.impl;

import com.springboot.dao.office.OfficeDao;
import com.springboot.domain.Office;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.office.OfficeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class OfficeUpdateServiceImpl implements OfficeUpdateService {
    @Autowired
    OfficeDao officeDaoImpl;

    @Override
    public int updateOffice(Office office) {
        return officeDaoImpl.updateOffice(office);
    }
}
