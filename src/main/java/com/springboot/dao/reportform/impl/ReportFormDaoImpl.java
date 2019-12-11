package com.springboot.dao.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
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
public class ReportFormDaoImpl implements ReportFormDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int reportFormAdd(ReportForm reportForm) {
        String sql = "INSERT INTO report_form VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,reportForm.getREPORTFORM_USERID(),reportForm.getREPORTFORM_TITLE(),reportForm.getREPORTFORM_CONTENT(),reportForm.getREPORTFORM_TIME()
        ,reportForm.getREPORTFORM_OFFICEID(),reportForm.getREPORTFORM_STATE(),reportForm.getREPORTFORM_IMG());
    }

    @Override
    public List<Map<String, Object>> getReportForm() {
        String sql = "SELECT * FROM report_form ORDER BY report_form.REPORTFORM_TIME DESC";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : result) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getReportFormByReportFormID(Integer REPORTFORM_ID) {
        String sql = "SELECT * FROM report_form " +
                "WHERE report_form.REPORTFORM_ID = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,REPORTFORM_ID);
        for (Map<String,Object> re : result) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getGetReportFormByDOCTORID(Integer DOCTOR_ID) {

        String sql = "SELECT * FROM report_form WHERE report_form.REPORTFORM_OFFICEID =(" +
                "SELECT DOCTOR_OFFICEID FROM doctor WHERE doctor.DOCTOR_ID = ?)";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,DOCTOR_ID);
        for (Map<String,Object> re : result) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getGetUnHandleReportFormByDOCTORID(Integer DOCTOR_ID) {
        String sql = "SELECT * FROM report_form WHERE report_form.REPORTFORM_STATE = '0'" +
                " AND report_form.REPORTFORM_OFFICEID =(" +
                "SELECT DOCTOR_OFFICEID FROM doctor WHERE doctor.DOCTOR_ID = ?)";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,DOCTOR_ID);
        for (Map<String,Object> re : result) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public int reportFormUpdate(ReportForm reportForm) {
        String sql = "UPDATE report_form " +
                "SET REPORTFORM_USERID = ?," +
                "REPORTFORM_TITLE = ?," +
                "REPORTFORM_CONTENT = ?," +
                "REPORTFORM_TIME = ?," +
                "REPORTFORM_OFFICEID = ?," +
                "REPORTFORM_STATE = ?," +
                "REPORTFORM_IMG = ?" +
                "WHERE REPORTFORM_ID = ?";
        return jdbcTemplate.update(sql,reportForm.getREPORTFORM_USERID(),reportForm.getREPORTFORM_TITLE(),reportForm.getREPORTFORM_CONTENT(),
                reportForm.getREPORTFORM_TIME(),reportForm.getREPORTFORM_OFFICEID(),reportForm.getREPORTFORM_STATE(),reportForm.getREPORTFORM_IMG(),
                reportForm.getREPORTFORM_ID());
    }

    @Override
    public int reportFormUpdateState(Integer REPORTFORM_ID, Integer newState) {
        String sql = "UPDATE report_form SET REPORTFORM_STATE = ? WHERE REPORTFORM_ID = ?";
        return jdbcTemplate.update(sql,newState,REPORTFORM_ID);
    }


    @Override
    public int ReportFormDelete(Integer REPORTFORM_ID) {
        String sql = "DELETE FROM report_form " +
                "WHERE REPORTFORM_ID = ?";
        return jdbcTemplate.update(sql,REPORTFORM_ID);
    }

    @Override
    public List<Map<String, Object>> getReportFormByUSERID(Integer USER_ID) {
        String sql = "SELECT * FROM report_form " +
                "WHERE report_form.REPORTFORM_USERID = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,USER_ID);
        for (Map<String,Object> re : result) {
            System.out.println(re);
        }
        return result;
    }
}
