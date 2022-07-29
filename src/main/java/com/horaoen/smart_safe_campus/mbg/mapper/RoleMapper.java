package com.horaoen.smart_safe_campus.mbg.mapper;

import com.horaoen.smart_safe_campus.mbg.model.Role;
import com.horaoen.smart_safe_campus.mbg.model.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role row);

    int insertSelective(Role row);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Role row, @Param("example") RoleExample example);

    int updateByExample(@Param("row") Role row, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role row);

    int updateByPrimaryKey(Role row);
}