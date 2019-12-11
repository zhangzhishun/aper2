package com.springboot.service.office;

import com.springboot.domain.Office;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface OfficeUpdateService {

    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    int updateOffice(Office office);
}
