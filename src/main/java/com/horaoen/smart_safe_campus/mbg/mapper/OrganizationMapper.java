package com.horaoen.smart_safe_campus.mbg.mapper;

import com.horaoen.smart_safe_campus.mbg.model.Organization;
import com.horaoen.smart_safe_campus.mbg.model.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Object organId);

    int insert(Organization row);

    int insertSelective(Organization row);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Object organId);

    int updateByExampleSelective(@Param("row") Organization row, @Param("example") OrganizationExample example);

    int updateByExample(@Param("row") Organization row, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization row);

    int updateByPrimaryKey(Organization row);
}