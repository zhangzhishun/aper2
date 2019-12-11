package com.springboot.service.office;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface OfficeGetService {

    /**
     * 获取所有office科室内容
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getAllOffice();

    /**
     * 根据科室名获取科室ID内容
     * @return List<Map<String, Object>>
     */
    Integer getOfficeIdByName(String OFFICE_NAME);

    /**
     * 根据科室名获取科室ID内容
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOfficeById(Integer OFFICE_ID);
}
