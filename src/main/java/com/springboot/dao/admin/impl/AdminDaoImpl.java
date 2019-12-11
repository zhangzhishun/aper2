package com.springboot.dao.admin.impl;

import com.springboot.dao.admin.AdminDao;
import com.springboot.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Admin getAdminById(String ADMIN_ID) {
        String sql = "SELECT * FROM admin WHERE ADMIN_ID=?";
        Admin admin = null;
        try{
            admin = jdbcTemplate.queryForObject(sql, new Object[]{ADMIN_ID}, new RowMapper<Admin>() {
                @Override
                public Admin mapRow(ResultSet rs, int paramInt) throws SQLException {
                    Admin c = new Admin();
                    c.setADMIN_ID(rs.getInt("ADMIN_ID"));
                    c.setADMIN_NAME(rs.getString("ADMIN_NAME"));
                    c.setADMIN_PASSWORD(rs.getString("ADMIN_PASSWORD"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return admin;
        }
        return admin;

    }

    @Override
    public Admin getAdminByName(String ADMIN_NAME) {
        String sql = "SELECT * FROM admin WHERE ADMIN_NAME=?";
        Admin admin = null;
        try{
            admin = jdbcTemplate.queryForObject(sql, new Object[]{ADMIN_NAME}, new RowMapper<Admin>() {
                @Override
                public Admin mapRow(ResultSet rs, int paramInt) throws SQLException {
                    Admin c = new Admin();
                    c.setADMIN_ID(rs.getInt("ADMIN_ID"));
                    c.setADMIN_NAME(rs.getString("ADMIN_NAME"));
                    c.setADMIN_PASSWORD(rs.getString("ADMIN_PASSWORD"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return admin;
        }
        return admin;
    }

    @Override
    public List<Map<String, Object>> getAllAdmin() {
        String sql = "SELECT * FROM admin";
        List<Map<String, Object>> admin = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : admin) {
            System.out.println(re);
        }
        return admin;
    }

    @Override
    public int adminDelete(Integer ADMIN_ID) {
        String sql = "DELETE FROM admin " +
                "WHERE ADMIN_ID = ?";
        System.out.println("delete");
        return jdbcTemplate.update(sql,ADMIN_ID);
    }

    @Override
    public int adminRegister(Admin admin) {
        String sql = "INSERT INTO admin VALUES(?,?,?)";
        return jdbcTemplate.update(sql,null,admin.getADMIN_NAME(),admin.getADMIN_PASSWORD());
    }

    @Override
    public int adminUpdate(Admin admin) {
        String sql = "UPDATE admin " +
                "SET ADMIN_PASSWORD = ?" +
                "WHERE ADMIN_NAME = ?";
        return jdbcTemplate.update(sql,admin.getADMIN_PASSWORD(),admin.getADMIN_NAME());
    }
}
