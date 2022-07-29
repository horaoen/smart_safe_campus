package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.PermissionDao;
import com.horaoen.smart_safe_campus.dao.RoleDao;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVo;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;
import com.horaoen.smart_safe_campus.service.PermissionService;
import com.horaoen.smart_safe_campus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired PermissionService permissionService;

    @Override
    public void deleteRoleDetailWithPermissionByRoleId(long roleId) {
        roleDao.deleteRoleDetailByRoleId(roleId);
        permissionDao.deleteByRoleId(roleId);
    }

    @Override
    public void addRoleDetailWithPermissions(RoleForCreateDto roleForCreateDto) {
        long id = roleDao.addRoleDetail(roleForCreateDto);
        permissionDao.addPermissions(id, roleForCreateDto.getPermissions());
    }

    @Override
    public List<RoleDetailVo> getAll() {
        return roleDao.getAll();
    }

    @Override
    public RoleDetailVoWithPermissionsVo getRoleDetailWithPermissionsByRoleId(long roleId) {
        return roleDao.getRoleDetailWithPermissionsByRoleId(roleId);
    }

    @Override
    public void deleteRoleDetailByRoleId(long roleId) {
        roleDao.deleteRoleDetailByRoleId(roleId);
    }

    @Override
    public long addRoleDetail(RoleForCreateDto roleForCreateDto) {
        return roleDao.addRoleDetail(roleForCreateDto);
    }

    @Override
    public void updateRoleDetail(long roleId, RoleForCreateDto roleForCreateDto) {
        roleDao.updateRoleDetail(roleId, roleForCreateDto);
        permissionService.updatePermissionByRoleId(roleId, roleForCreateDto);
    }

}
