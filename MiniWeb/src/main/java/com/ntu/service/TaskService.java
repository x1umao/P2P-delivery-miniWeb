package com.ntu.service;

import com.ntu.dao.MessageDao;
import com.ntu.dao.TaskDao;
import com.ntu.dao.UserDao;
import com.ntu.domain.Message;
import com.ntu.domain.Task;
import com.ntu.domain.User;

import java.util.List;

public class TaskService {

    private final TaskDao taskDao = new TaskDao();
    private final UserDao userDao = new UserDao();
    private final MessageDao msgDao = new MessageDao();

    public int addNewTask(Task newTask){
        return taskDao.addNewTask(newTask);
    }

    public List<Task> getTaskByPage(int pageNum, int status, User user) {
        if (status == 0){
            return taskDao.getTaskByPage(pageNum,user.getUid());
        }
        if (status == 1){
            return taskDao.getTaskByCustomer(pageNum,user.getUid());
        }
        if (status == 2){
            return taskDao.getTaskByDriver(pageNum,user.getUid(),user.getUsername());//添加通过聊天查询task
        }
        else {
            return taskDao.getTaskByTid(status,user.getUid());
        }
    }

    public int deletePostByTid(int tid) {
        return taskDao.deletePostByTid(tid);
    }

    public int dealTask(String tid, String driver, String customer) {

        String sendToCustomer = "Your delivery request is confirmed with <b>" +
                driver+
                "</b>. Please arrange further delivery details with the driver offline.";
        String sendToDriver = "Your delivery job is confirmed with <b>" +
                customer +
                "</b>. Please arrange further delivery details with the customer offline.";
        Message customerMsg = new Message();
        Message driverMsg = new Message();
        customerMsg.setTalker("System");
        customerMsg.setTaskId(Integer.parseInt(tid));
        customerMsg.setListener(customer);
        customerMsg.setMessage(sendToCustomer);

        driverMsg.setTalker("System");
        driverMsg.setTaskId(Integer.parseInt(tid));
        driverMsg.setListener(driver);
        driverMsg.setMessage(sendToDriver);

        msgDao.setMsg(customerMsg);
        msgDao.setMsg(driverMsg);

        //query driver_id by username;
        User dUser = userDao.findByUsername(driver);

        return taskDao.dealTask(tid,dUser.getUid());
    }
}
