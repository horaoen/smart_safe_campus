package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.vo.OrganNodeVo;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {
    void deepDeleteOrgans(List<String> ids);
    List<OrganNodeVo> getAllRegion();
    OrganizationVo getOrganById(String organId);
    List<SimpleOrganVo> getOrgansByParentId(UUID parentId);
    void deleteByIds(List<String> ids);
    void addOrganization(OrganizationForCreateDto organization);
    void updateOrganization(OrganizationForCreateDto organization);
}
