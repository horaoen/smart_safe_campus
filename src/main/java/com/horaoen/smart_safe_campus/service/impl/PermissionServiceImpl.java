package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.PermissionDao;
import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;
import com.horaoen.smart_safe_campus.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void updatePermissionByRoleId(long roleId, RoleForCreateDto roleForCreateDto) {
        permissionDao.deleteByRoleId(roleId);
        permissionDao.addPermissions(roleId, roleForCreateDto.getPermissions());
    }

    @Override
    public List<String> getPermissionsByRoleId(long roleId) {
        return permissionDao.getPermissionsByRoleId(roleId);
    }

    @Override
    public void deleteByRoleId(long roleId) {
        permissionDao.deleteByRoleId(roleId);
    }

    @Override
    public void addPermissions(long roleId, List<String> permissions) {
        permissionDao.addPermissions(roleId, permissions);
    }
}
