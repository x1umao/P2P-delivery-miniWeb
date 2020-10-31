package com.ntu.dao;

import com.ntu.domain.Task;
import com.ntu.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class TaskDao {

    private static final JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public List<Task> getAllTask() {
        String sql = "select * from user,task where task.customer_id = user.uid;";
        List<Task> query = template.query(sql, new BeanPropertyRowMapper<>(Task.class));
        return query;
    }

    public Object getTaskLength() {
        String sql = "select count(tid) from task";
        Map<String, Object> map = template.queryForMap(sql);
        return map.get("count(tid)");
    }

    /***
     * page size is 5
     * @param pageNum
     * @param uid
     * @return
     */
    public List<Task> getTaskByPage(int pageNum, Integer uid) {
        String sql = "select * from task,user where task.customer_id = user.uid and task.customer_id!=? and status = 1 order by task.pickup_time  limit ?,5";
        return template.query(sql, new BeanPropertyRowMapper<>(Task.class),uid,pageNum * 5);
    }


    public List<Task> getTaskByCustomer(int pageNum, int uid) {
        String sql = "select * from task,user where task.customer_id = user.uid and task.customer_id = ? order by task.tid desc limit ?,5";
        return template.query(sql, new BeanPropertyRowMapper<>(Task.class),uid,pageNum * 5);
    }

    public List<Task> getTaskByDriver(int pageNum, int uid, String username) {
//        String sql = " select task.*,user.username from user,task,msg where task.driver_id = ? or(msg.talker = ? and msg.task_id = task.tid and task.customer_id!=?) group by task.tid order by task.tid desc limit ?,5";
//        String sql = "select * from task,user,msg where task.customer_id = user.uid and (task.driver_id = ? or msg.talker=?) group by task.tid order by task.tid desc limit ?,5";
        String sql = "(select task.*, user.username "+
        "from task, user "+
        "where task.tid = any (select task_id from msg where talker = ?) "+
        "and task.customer_id != ? "+
        "and task.customer_id = user.uid) "+
        "union "+
        "(select task.*, user.username from task,user where task.customer_id = user.uid and task.driver_id = ?) "+
        "order by tid desc limit ?,5";
        return template.query(sql, new BeanPropertyRowMapper<>(Task.class),username,uid,uid,pageNum * 5);
    }


    public int addNewTask(Task newTask) {
        String sql = "INSERT INTO " +
                "task (customer_id, driver_id, pickup_time, deliver_time, pickup_address, deliver_address, remarks, status, post_time) " +
                "VALUES (?, null, ?, ?, ?, ?, ?, 1, current_timestamp)";
        return template.update(sql,
                newTask.getCustomerId(),
                newTask.getPickupTime(),
                newTask.getDeliverTime(),
                newTask.getPickupAddress(),
                newTask.getDeliverAddress(),
                newTask.getRemarks());
    }

    public List<Task> getTaskByTid(int tid, Integer uid) {
        String sql = "select * from task,user where task.tid = ? and task.customer_id = user.uid";
        return template.query(sql, new BeanPropertyRowMapper<>(Task.class), tid);
    }

    public int deletePostByTid(int tid) {
        String sql = "UPDATE task SET status = 3 WHERE tid = ? ";
        return template.update(sql,tid);
    }

    public int dealTask(String tid, Integer driverId) {
        String sql = "update task set status = 2,driver_id = ? where tid = ?";
        return template.update(sql,driverId,tid);
    }
}
