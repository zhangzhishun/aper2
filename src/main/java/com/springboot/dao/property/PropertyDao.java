package com.springboot.dao.property;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface PropertyDao {
    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    List<Map<String,Object>> getProperty();

    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    List<Map<String,Object>> getValue(String key);

    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    int updateKey(String key,String newValue);
}
