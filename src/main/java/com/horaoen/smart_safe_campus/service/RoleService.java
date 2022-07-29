package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.model.vo.RoleDetailVo;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;

import java.util.List;

public interface RoleService {
    void deleteRoleDetailWithPermissionByRoleId(long roleId);
    void addRoleDetailWithPermissions(RoleForCreateDto roleForCreateDto);
    List<RoleDetailVo> getAll();
    RoleDetailVoWithPermissionsVo getRoleDetailWithPermissionsByRoleId(long roleId);
    void deleteRoleDetailByRoleId(long roleId);
    long addRoleDetail(RoleForCreateDto roleForCreateDto);
    void updateRoleDetail(long roleId, RoleForCreateDto roleForCreateDto);
}
