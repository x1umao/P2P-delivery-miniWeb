package com.ntu.dao;

import com.ntu.domain.User;
import com.ntu.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {


    private static final JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public int setUser(User user) {
        String sql = "insert into user values (null,?,?,?,0)";//0: normal
        return template.update(sql,
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }

    public User findByEmailAndPassword(String email,String password) {
        User user = null;
        String sql = "select * from user where email = ? and password = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email, password);
        } catch (DataAccessException ignored) {
        }
        return user;
    }

    public User findByUsernameAndEmail(String username, String email) {
        User user = null;
        String sql = "select * from user where username = ? or email = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username, email);
        } catch (DataAccessException ignored) {
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = null;
        String sql = "select * from user where username = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        } catch (DataAccessException ignored) {
        }
        return user;
    }
}
