package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;

import java.util.List;

public interface PermissionService {
    void updatePermissionByRoleId(long roleId, RoleForCreateDto roleForCreateDto);
    List<String> getPermissionsByRoleId(long roleId);
    void deleteByRoleId(long roleId);
    void addPermissions(long roleId, List<String> permissions);
}
