package com.springboot.dao.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
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
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Doctor getDoctorByName(String DOCTOR_NAME) {
        String sql = "SELECT * FROM doctor WHERE DOCTOR_NAME=?";
        Doctor doctor = null;
        try{
            doctor = jdbcTemplate.queryForObject(sql, new Object[]{DOCTOR_NAME}, new RowMapper<Doctor>() {
                @Override
                public Doctor mapRow(ResultSet rs, int paramInt) throws SQLException {
                    Doctor c = new Doctor();
                    c.setDOCTOR_NAME(rs.getString("DOCTOR_NAME"));
                    c.setDOCTOR_ID(rs.getInt("DOCTOR_ID"));
                    c.setDOCTOR_PASSWORD(rs.getString("DOCTOR_PASSWORD"));
                    c.setDOCTOR_REALNAME(rs.getString("DOCTOR_REALNAME"));
                    c.setDOCTOR_SEX(rs.getString("DOCTOR_SEX"));
                    c.setDOCTOR_PHONE(rs.getString("DOCTOR_PHONE"));
                    c.setDOCTOR_WECHAT(rs.getString("DOCTOR_WECHAT"));
                    c.setDOCTOR_OFFICEID(rs.getInt("DOCTOR_OFFICEID"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return doctor;
        }
        return doctor;

    }

    @Override
    public List<Map<String, Object>> getDoctorById(Integer DOCTOR_ID) {
        String sql = "SELECT * FROM doctor WHERE DOCTOR_ID =?";
        List<Map<String, Object>> doctor = jdbcTemplate.queryForList(sql,DOCTOR_ID);
        for (Map<String,Object> re : doctor) {
            System.out.println(re);
        }
        return doctor;
    }

    @Override
    public List<Map<String, Object>> getAllDoctor() {
        String sql = "SELECT * FROM doctor";
        List<Map<String, Object>> doctor = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : doctor) {
            System.out.println(re);
        }
        return doctor;
    }

    @Override
    public int doctorDelete(Integer DOCTOR_ID) {
        String sql = "DELETE FROM doctor " +
                "WHERE DOCTOR_ID = ?";
        return jdbcTemplate.update(sql,DOCTOR_ID);
    }

    @Override
    public int doctorRegister(Doctor doctor) {
        String sql = "INSERT INTO doctor VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,doctor.getDOCTOR_NAME(),doctor.getDOCTOR_PASSWORD(),
                doctor.getDOCTOR_REALNAME(),doctor.getDOCTOR_SEX(),doctor.getDOCTOR_PHONE(),doctor.getDOCTOR_WECHAT(),doctor.getDOCTOR_OFFICEID());
    }

    @Override
    public int doctorUpdate(Doctor doctor) {
        String sql = "UPDATE doctor " +
                "SET DOCTOR_PASSWORD = ?,DOCTOR_REALNAME = ?,DOCTOR_SEX = ?,DOCTOR_PHONE = ?,DOCTOR_WECHAT = ?,DOCTOR_OFFICEID = ? " +
                "WHERE DOCTOR_NAME = ?";
        return jdbcTemplate.update(sql,doctor.getDOCTOR_PASSWORD(),doctor.getDOCTOR_REALNAME(),doctor.getDOCTOR_SEX(),doctor.getDOCTOR_PHONE(),
                doctor.getDOCTOR_WECHAT(),doctor.getDOCTOR_OFFICEID(),doctor.getDOCTOR_NAME());
    }
}
