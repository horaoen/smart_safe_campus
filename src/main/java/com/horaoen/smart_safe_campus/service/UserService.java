package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.model.vo.UserVo;

import java.util.List;

public interface UserService {
    List<UserVo> getAllUsers();

    void deleteUser(String userId);

    void createUser(UserForCreationDto user);

    void updateUser(String userId, UserForCreationDto user);
}
