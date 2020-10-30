package com.ntu.service;

import com.ntu.dao.UserDao;
import com.ntu.domain.User;

public class UserService {

    private final UserDao userDao = new UserDao();

    public int register(User user){
        User u = userDao.findByUsernameAndEmail(user.getUsername(), user.getEmail());
        if(u != null){
            return 0;
        }
        return userDao.setUser(user);
    }


    public User login(User user){
        return userDao.findByEmailAndPassword(user.getEmail(),user.getPassword());
    }
}
