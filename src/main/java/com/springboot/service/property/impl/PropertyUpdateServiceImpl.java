package com.springboot.service.property.impl;

import com.springboot.dao.property.PropertyDao;
import com.springboot.service.property.PropertyGetService;
import com.springboot.service.property.PropertyUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class PropertyUpdateServiceImpl implements PropertyUpdateService {

    @Autowired
    PropertyDao propertyDaoImpl;

    @Override
    public int updateKey(String key, String newValue) {
        return propertyDaoImpl.updateKey(key,newValue);
    }
}
