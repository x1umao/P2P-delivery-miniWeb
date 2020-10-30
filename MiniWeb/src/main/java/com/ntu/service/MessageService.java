package com.ntu.service;

import com.ntu.dao.MessageDao;
import com.ntu.domain.Message;
import com.ntu.domain.User;

import java.util.List;

public class MessageService {
    private MessageDao messageDao = new MessageDao();
    public int setMsg(Message message) {
        return messageDao.setMsg(message);
    }

    public List<Message> findTalkerByTid(int tid, User user) {
        return messageDao.findTalkerByTidAndUser(tid,user.getUsername());
    }
}
