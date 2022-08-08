package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import com.horaoen.smart_safe_campus.service.RoleService;
import com.horaoen.smart_safe_campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void createUser(UserForCreationDto user) {
        user.setCreateTime(new Date());
        user.setId(UUID.randomUUID().toString());
        userDao.createUser(user);
    }

    @Override
    public void updateUser(String userId, UserForCreationDto user) {
        user.setId(userId);
        userDao.updateUser(user);
    }
}
