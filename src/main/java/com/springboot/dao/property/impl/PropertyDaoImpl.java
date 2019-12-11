package com.springboot.dao.property.impl;

import com.springboot.dao.property.PropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class PropertyDaoImpl implements PropertyDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getProperty() {
        String sql = "SELECT * FROM property";
        List<Map<String, Object>> property = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : property) {
            System.out.println(re);
        }
        return property;
    }

    @Override
    public List<Map<String, Object>> getValue(String key) {
        String sql = "SELECT * FROM property WHERE PROPERTY_NAME=?";
        List<Map<String, Object>> property = jdbcTemplate.queryForList(sql,key);
        return property;
    }

    @Override
    public int updateKey(String key, String newValue) {
        String sql = "UPDATE property " +
                "SET PROPERTY_VALUE = ?" +
                "WHERE PROPERTY_NAME = ?";
        return jdbcTemplate.update(sql,newValue,key);
    }

}
