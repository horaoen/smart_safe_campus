package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void createUser(UserForCreationDto user) {
        userDao.createUser(user);
    }
}
