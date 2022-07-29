package com.horaoen.smart_safe_campus.mbg.mapper;

import com.horaoen.smart_safe_campus.mbg.model.Permission;
import com.horaoen.smart_safe_campus.mbg.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission row);

    int insertSelective(Permission row);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Permission row, @Param("example") PermissionExample example);

    int updateByExample(@Param("row") Permission row, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission row);

    int updateByPrimaryKey(Permission row);
}