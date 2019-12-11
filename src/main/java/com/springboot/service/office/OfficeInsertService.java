package com.springboot.service.office;

import com.springboot.domain.Office;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface OfficeInsertService {

    /**
     * 用户注册
     * @return int
     */
    int officeInsert(Office office);
}
