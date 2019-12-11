package com.springboot.service.property;

/**
 * @author eternalSy
 * @version 1.0.0
 */

public interface PropertyUpdateService {
    /**
     * 通过PROPERTY_NAME获取Property
     * return String
     **/
    int updateKey(String key,String newValue);
}
