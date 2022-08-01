package com.horaoen.smart_safe_campus.dao;

import com.horaoen.smart_safe_campus.mbg.model.Role;
import com.horaoen.smart_safe_campus.mbg.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User findUserByUsername(String username);
    Role getRoleByUserId(Long userId);
    List<User> getAllUsers();
}
