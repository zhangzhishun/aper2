package com.springboot.service.user;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserGetMyReportService {
    /**
     * 向ReportForm插入数据
     * @return boolean*/
    List<Map<String,Object>> UserGetMyReportByUSERID(Integer USER_ID);

}
