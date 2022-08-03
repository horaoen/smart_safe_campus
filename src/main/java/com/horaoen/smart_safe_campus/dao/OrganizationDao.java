package com.horaoen.smart_safe_campus.dao;

import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

/**
 * @author horaoen
 */

@Mapper
public interface OrganizationDao {
    List<SimpleOrganVo> getAllRegion();
    OrganizationVo getOrganById(String organId);
    List<SimpleOrganVo> getOrgansByParentId(UUID parentId);
    void deleteByIds(List<String> ids);
    void addOrganization(OrganizationForCreateDto organization);
    void updateOrganization(OrganizationForCreateDto organization);
}
