package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author horaoen
 */
@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        List<User> all = userDao.getAll();
        return  all;
    }

}
