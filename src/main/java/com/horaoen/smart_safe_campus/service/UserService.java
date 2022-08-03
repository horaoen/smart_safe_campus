package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void deleteUser(long userId);

    void createUser(UserForCreationDto user);
}
