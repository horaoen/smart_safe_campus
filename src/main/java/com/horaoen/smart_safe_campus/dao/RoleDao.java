package com.horaoen.smart_safe_campus.dao;

import com.horaoen.smart_safe_campus.model.vo.RoleDetailVo;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author horaoen
 */
@Mapper
public interface RoleDao {
    List<RoleDetailVo> getAll();
    RoleDetailVoWithPermissionsVo getRoleDetailWithPermissionsByRoleId(long roleId);
    void deleteRoleDetailByRoleId(long roleId);
    long addRoleDetail(RoleForCreateDto roleForCreateDto);
    void updateRoleDetail(long roleId, RoleForCreateDto roleForCreateDto);
}
