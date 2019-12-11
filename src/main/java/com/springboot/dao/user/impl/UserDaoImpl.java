package com.springboot.dao.user.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.Reply;
import com.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByName(String USER_NAME) {
        String sql = "SELECT * FROM user WHERE USER_NAME=?";
        User user = null;
        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{USER_NAME}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int paramInt) throws SQLException {
                    User c = new User();
                    c.setUSER_ID(rs.getInt("USER_ID"));
                    c.setUSER_NAME(USER_NAME);
                    c.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
                    c.setUSER_PHONE(rs.getString("USER_PHONE"));
                    c.setUSER_SEX(rs.getString("USER_SEX"));
                    c.setUSER_REALNAME(rs.getString("USER_REALNAME"));
                    c.setUSER_WECHAT(rs.getString("USER_WECHAT"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return user;
        }
        return user;
    }

    @Override
    public List<Map<String, Object>> getUser() {
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> user = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : user) {
            System.out.println(re);
        }
        return user;
    }

    @Override
    public int userRegister(User user) {
        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,user.getUSER_NAME(),user.getUSER_PASSWORD(),user.getUSER_PHONE(),user.getUSER_SEX(),
                user.getUSER_REALNAME(),user.getUSER_WECHAT());
    }

    @Override
    public int userUpdate(User user) {
        String sql = "UPDATE user " +
                "SET USER_PASSWORD = ?," +
                "USER_PHONE = ?," +
                "USER_SEX = ?," +
                "USER_REALNAME = ?," +
                "USER_WECHAT = ?" +
                "WHERE USER_NAME = ?";
        return jdbcTemplate.update(sql,user.getUSER_PASSWORD(),user.getUSER_PHONE(),user.getUSER_SEX(),
                user.getUSER_REALNAME(),user.getUSER_WECHAT(),user.getUSER_NAME());
    }

    @Override
    public int deleteUser(Integer USER_ID) {
        String sql = "DELETE FROM user " +
                "WHERE USER_ID = ?";
        return jdbcTemplate.update(sql,USER_ID);
    }
}
