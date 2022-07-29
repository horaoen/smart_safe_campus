package com.horaoen.smart_safe_campus.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {
    List<String> getPermissionsByRoleId(long roleId);
    void deleteByRoleId(long roleId);
    void addPermissions(long roleId, List<String> permissions);
}
