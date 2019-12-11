package com.springboot.dao.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.domain.Reply;
import com.springboot.domain.User;
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
public class ReplyDaoImpl implements ReplyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME){
        String sql = "SELECT * FROM user,reply,report_form " +
                "WHERE reply.REPLY_REPOTFORMID = report_form.REPORTFORM_ID " +
                "AND report_form.REPORTFORM_USERID = user.USER_ID AND user.USER_NAME=? ORDER BY reply.REPLY_TIME DESC";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{USER_NAME});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }

    @Override
    public List<Map<String, Object>> getGetReplyByDOCTORID(Integer DOCTOR_ID) {
        String sql = "SELECT * FROM user,reply,report_form " +
                "WHERE reply.REPLY_REPOTFORMID = report_form.REPORTFORM_ID " +
                "AND report_form.REPORTFORM_USERID = user.USER_ID AND reply.REPLY_DOCTORID=? ORDER BY reply.REPLY_TIME DESC";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{DOCTOR_ID});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }

    @Override
    public List<Map<String, Object>> getReplyAndUserByREPLYID(String REPLY_ID) {
        String sql = "SELECT * FROM user,reply,report_form " +
                "WHERE reply.REPLY_REPOTFORMID = report_form.REPORTFORM_ID " +
                "AND report_form.REPORTFORM_USERID = user.USER_ID AND reply.REPLY_ID=?";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{REPLY_ID});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }

    @Override
    public List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID) {
        String sql = "SELECT * FROM reply WHERE REPLY_ID=?";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{REPLY_ID});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }

    @Override
    public Integer updateReplyState(String REPLY_ID,Integer newState) {
        String sql = "UPDATE reply SET REPLY_STATE = ? WHERE REPLY_ID = ?";
        return jdbcTemplate.update(sql,newState,REPLY_ID);
    }

    @Override
    public List<Map<String, Object>> getReply() {
        String sql = "SELECT * FROM reply";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql);
        return reply;
    }

    @Override
    public int replyUpdate(Reply reply) {
        String sql = "UPDATE reply " +
                "SET REPLY_REPOTFORMID = ? , " +
                "REPLY_DOCTORID = ? , " +
                "REPLY_CONTENT = ? , " +
                "REPLY_TIME = ? , " +
                "REPLY_IMG = ? , " +
                "REPLY_STATE = ? " +
                "WHERE REPLY_ID = ?";
        return jdbcTemplate.update(sql,reply.getREPLY_REPOTFORMID(),reply.getREPLY_DOCTORID(),reply.getREPLY_CONTENT(),
                reply.getREPLY_TIME(),reply.getREPLY_IMG(),reply.getREPLY_STATE(),reply.getREPLY_ID());
    }

    @Override
    public int replyDelete(Integer REPLY_ID) {
        String sql = "DELETE FROM reply " +
                "WHERE REPLY_ID = ?";
        return jdbcTemplate.update(sql,REPLY_ID);
    }

    @Override
    public int replyInsert(Reply reply) {
        String sql = "INSERT INTO reply VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,reply.getREPLY_REPOTFORMID(),reply.getREPLY_DOCTORID(),reply.getREPLY_CONTENT(),
                reply.getREPLY_TIME(),reply.getREPLY_IMG(),reply.getREPLY_STATE());
    }
}
