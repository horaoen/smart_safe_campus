package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {
    void deepDeleteOrgans(List<UUID> ids);
    List<SimpleOrganVo> getAllRegion();
    OrganizationVo getOrganById(UUID organId);
    List<SimpleOrganVo> getOrgansByParentId(UUID parentId);
    void deleteByIds(List<UUID> ids);
    void addOrganization(OrganizationForCreateDto organization);
    void updateOrganization(OrganizationForCreateDto organization);
}
