package com.springboot.service.office.impl;

import com.springboot.dao.office.OfficeDao;
import com.springboot.dao.reply.ReplyDao;
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
public class OfficeGetServiceImpl implements OfficeGetService {
    @Autowired
    OfficeDao officeDaoImpl;

    @Override
    public List<Map<String, Object>> getAllOffice() {
        List<Map<String, Object>> result=  officeDaoImpl.getAllOffice();
        return result;
    }

    @Override
    public Integer getOfficeIdByName(String OFFICE_NAME) {
        List<Map<String, Object>> allOffice=  officeDaoImpl.getAllOffice();
        Integer result = new Integer(0);
        for (Map<String,Object> office:allOffice
             ) {
            if(office.get("OFFICE_NAME").equals(OFFICE_NAME)){
                result = (Integer) office.get("OFFICE_ID");
            }
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getOfficeById(Integer OFFICE_ID) {
        return officeDaoImpl.getOfficeByOFFICEID(OFFICE_ID);
    }
}
