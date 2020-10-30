package com.ntu.dao;

import com.ntu.domain.Message;
import com.ntu.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MessageDao {
    private static final JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public int setMsg(Message message) {
        String sql = "insert into msg values (null,?,?,?,current_timestamp,?)";
        return template.update(sql,
                message.getTalker(),
                message.getListener(),
                message.getMessage(),
                message.getTaskId());
    }

    public List<Message> findTalkerByTidAndUser(int tid, String username) {
        String sql = "select * from msg where (task_id = ?) and (talker = ? or listener = ?) order by post_time";
        return template.query(sql, new BeanPropertyRowMapper<>(Message.class), tid,username,username);
    }
}
