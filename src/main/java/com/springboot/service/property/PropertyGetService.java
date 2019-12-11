package com.springboot.service.property;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */

public interface PropertyGetService {
    /**
     * 通过PROPERTY_NAME获取Property
     * return String
     **/
    String getPropertyByPROPERTYNAME(String PROPERTY_NAME);
}
