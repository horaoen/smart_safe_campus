package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.OrganizationDao;
import com.horaoen.smart_safe_campus.mbg.mapper.OrganizationMapper;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.OrganizationType;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public void deepDeleteOrgans(List<UUID> ids) {
        for (UUID id: ids) {
            List<SimpleOrganVo> subOrgans = organizationDao.getOrgansByParentId(id);
            for (SimpleOrganVo subOrgan: subOrgans) {
                if(subOrgan.getOrganType() != OrganizationType.CLASS) {
                    UUID subId = subOrgan.getId();
                    deepDeleteOrgans(new ArrayList<UUID>(Collections.singleton(subId)));
                }
            }
        }
        organizationDao.deleteByIds(ids);
    }

    @Override
    public List<SimpleOrganVo> getAllRegion() {
        return organizationDao.getAllRegion();
    }

    @Override
    public OrganizationVo getOrganById(UUID organId) {
        return organizationDao.getOrganById(organId);
    }

    @Override
    public List<SimpleOrganVo> getOrgansByParentId(UUID parentId) {
        return organizationDao.getOrgansByParentId(parentId);
    }

    @Override
    public void deleteByIds(List<UUID> ids) {
        organizationDao.deleteByIds(ids);
    }

    @Override
    public void addOrganization(OrganizationForCreateDto organization) {
        organizationDao.addOrganization(organization);
    }

    @Override
    public void updateOrganization(OrganizationForCreateDto organization) {
        organizationDao.updateOrganization(organization);
    }
}
