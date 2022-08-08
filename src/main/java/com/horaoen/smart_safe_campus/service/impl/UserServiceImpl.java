package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.Organization;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.vo.UserVo;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import com.horaoen.smart_safe_campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrganizationService organizationService;
    @Override
    public List<UserVo> getAllUsers() {
        List<UserVo> allUsers = userDao.getAllUsers();
        setUserOrganName(allUsers);
        setUserClassName(allUsers);
        return allUsers;
    }

    public void setUserOrganName(List<UserVo> users) {
        for (UserVo user : users) {
            OrganizationVo userOrgan = organizationService.getOrganById(user.getOrganId());
            if(userOrgan.getOrganType() == 1) {
                user.setOrganName(userOrgan.getOrganName());
            } else {
                StringBuffer organName = new StringBuffer();
                OrganizationVo parentOrgan = organizationService.getOrganById(userOrgan.getParentId());
                while(parentOrgan != null) {
                    organName.insert(0, parentOrgan.getOrganName() + "-");
                    String parentId = parentOrgan.getParentId();
                    if(parentId != null) parentOrgan = organizationService.getOrganById(parentId);
                    else parentOrgan = null;
                }
                if (organName.toString().endsWith("-"))
                    organName.deleteCharAt(organName.length() - 1);
                user.setOrganName(organName.toString());
            }
        }
    }

    public void setUserClassName(List<UserVo> users) {
        for (UserVo user : users) {
            OrganizationVo userOrgan = organizationService.getOrganById(user.getOrganId());
            int organType = userOrgan.getOrganType();
            if(organType == 1) {
                user.setClassName("本地全部学校");
            } else if(organType == 2) {
                user.setClassName("全部班级");
            } else {
                user.setClassName(userOrgan.getOrganName());
            }
        }
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
