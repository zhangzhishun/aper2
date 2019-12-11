package com.springboot.dao.advice.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.domain.Advice;
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
public class AdviceaoImpl implements AdviceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertAdvice(Advice advice) {
        String sql = "INSERT INTO advice VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,advice.getADVICE_TITLE(),advice.getADVICE_CONTENT(),advice.getADVICE_TIME(),
                advice.getADVICE_REPLY(),advice.getADVICE_REPLY_TIME(),advice.getUSER_ID());
    }

    @Override
    public int deleteAdvice(Integer ADVICE_ID) {
        String sql = "DELETE FROM advice " +
                "WHERE ADVICE_ID = ?";
        return jdbcTemplate.update(sql,ADVICE_ID);
    }

    @Override
    public List<Map<String, Object>> getAdviceByADVICEID(String ADVICE_ID) {
        String sql = "SELECT * FROM advice WHERE ADVICE_ID=?";
        List<Map<String, Object>> advice = jdbcTemplate.queryForList(sql,ADVICE_ID);
        for (Map<String,Object> re : advice) {
            System.out.println(re);
        }
        return advice;
    }

    @Override
    public List<Map<String, Object>> getAllAdvice() {
        String sql = "SELECT * FROM advice";
        List<Map<String, Object>> advice = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : advice) {
            System.out.println(re);
        }
        return advice;
    }
}
