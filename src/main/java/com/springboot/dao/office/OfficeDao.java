package com.springboot.dao.office;

import com.springboot.domain.Office;
import com.springboot.domain.Reply;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface OfficeDao {

    /**
     * 获取所有office科室内容
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getAllOffice();

    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    List<Map<String,Object>> getOfficeByOFFICEID(Integer OFFICE_ID);

    /**
     * 获取Property
     * return List<Map<String,Object>
     **/
    int updateOffice(Office office);

    /**
     * 删除
     * @return Doctor
     */
    int officeDelete(Integer OFFICE_ID);

    /**
     * 用户注册
     * @return int
     */
    int officeInsert(Office office);
}
