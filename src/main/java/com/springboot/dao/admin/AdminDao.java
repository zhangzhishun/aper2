package com.springboot.dao.admin;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Admin
     */
    Admin getAdminById(String ADMIN_ID);

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Admin
     */
    Admin getAdminByName(String ADMIN_NAME);

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Doctor
     */
    List<Map<String, Object>> getAllAdmin();

    /**
     * 删除
     * @return Doctor
     */
    int adminDelete(Integer ADMIN_ID);

    /**
     * 注册
     * @return int
     */
    int adminRegister(Admin admin);

    /**
     * 更新
     * @return int
     */
    int adminUpdate(Admin admin);
}
