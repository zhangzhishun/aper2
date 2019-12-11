package com.springboot.service.property.impl;

import com.springboot.dao.property.PropertyDao;
import com.springboot.service.property.PropertyGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class PropertyGetServiceImpl implements PropertyGetService {

    @Autowired
    PropertyDao propertyDaoImpl;

    @Override
    public String getPropertyByPROPERTYNAME(String PROPERTY_NAME) {
        List<Map<String, Object>> allProperty = propertyDaoImpl.getProperty();
        String result = new String();
        for (Map<String,Object> re : allProperty) {
            if(re.get("PROPERTY_NAME").equals(PROPERTY_NAME)){
                for(Map.Entry<String, Object> vo : re.entrySet()){
                    result = String.valueOf(vo.getValue());
                }
            }
        }
        return result;
    }
}
