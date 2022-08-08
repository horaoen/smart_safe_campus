package com.horaoen.smart_safe_campus.dao;

import com.horaoen.smart_safe_campus.mbg.model.Role;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.model.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User findUserByUsername(String username);
    Role getRoleByUserId(String userId);
    List<UserVo> getAllUsers();
    void deleteUser(String userId);

    void createUser(UserForCreationDto user);

    void updateUser(UserForCreationDto user);
}
