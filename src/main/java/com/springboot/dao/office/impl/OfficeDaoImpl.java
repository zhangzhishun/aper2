package com.springboot.dao.office.impl;

import com.springboot.dao.office.OfficeDao;
import com.springboot.domain.Office;
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
public class OfficeDaoImpl implements OfficeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllOffice() {
        String sql = "SELECT * FROM office";
        List<Map<String, Object>> office = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : office) {
            System.out.println(re);
        }
        return office;
    }

    @Override
    public List<Map<String, Object>> getOfficeByOFFICEID(Integer OFFICE_ID) {
        String sql = "SELECT * FROM office WHERE OFFICE_ID=?";
        List<Map<String, Object>> office = jdbcTemplate.queryForList(sql,OFFICE_ID);
        for (Map<String,Object> re : office) {
            System.out.println(re);
        }
        return office;
    }

    @Override
    public int updateOffice(Office office) {
        String sql = "UPDATE office " +
                "SET OFFICE_NAME = ?" +
                "WHERE OFFICE_ID = ?";
        return jdbcTemplate.update(sql,office.getOFFICE_NAME(),office.getOFFICE_ID());
    }

    @Override
    public int officeDelete(Integer OFFICE_ID) {
        String sql = "DELETE FROM office " +
                "WHERE OFFICE_ID = ?";
        return jdbcTemplate.update(sql,OFFICE_ID);
    }

    @Override
    public int officeInsert(Office office) {
        String sql = "INSERT INTO office VALUES(?,?)";
        return jdbcTemplate.update(sql,null,office.getOFFICE_NAME());
    }
}
