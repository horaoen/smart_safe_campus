package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.dao.OrganizationDao;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.OrganNodeVo;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public void deepDeleteOrgans(List<String> ids) {
        List<SimpleOrganVo> organList = organizationDao.getAllRegion();
        Set<String> toDeleteIds = new HashSet<>(ids);
        Set<SimpleOrganVo> organs = organList.stream()
                .filter(organItem -> ids.contains(organItem.getOrganId()))
                .collect(Collectors.toSet());
        for (SimpleOrganVo organ: organs) {
            toDeleteIds.addAll(getAllSubOrgansId(organ, organList));
        }
        organizationDao.deleteByIds(new ArrayList<>(toDeleteIds));
    }


    private Set<String> getAllSubOrgansId(SimpleOrganVo organ, List<SimpleOrganVo> organList) {
        Set<String> ids = new HashSet<>();
        ids.add(organ.getOrganId());
        organList.stream()
                .filter(organItem -> organ.getOrganId().equals(organItem.getParentId()) && organItem.getOrganType() != 1)
                .map(organItem ->
                    ids.addAll(getAllSubOrgansId(organItem, organList))
                )
                .collect(Collectors.toList());
        return ids;
    }
    @Override
    public List<OrganNodeVo> getAllRegion() {
        List<SimpleOrganVo> organList = organizationDao.getAllRegion();
        List<OrganNodeVo> organNodeList = organList.stream()
                .filter(organ -> organ.getOrganType() == 1)
                .map(organ -> convertToOrganNodeVo(organ, organList)).collect(Collectors.toList());
        return organNodeList;
    }

    private OrganNodeVo convertToOrganNodeVo(SimpleOrganVo organ, List<SimpleOrganVo> organList) {
        OrganNodeVo organNode = new OrganNodeVo();
        BeanUtils.copyProperties(organ, organNode);
        List<OrganNodeVo> children = organList.stream()
                .filter(organItem -> organ.getOrganId().equals(organItem.getParentId()) && organItem.getOrganType() != 1)
                .map(organItem -> convertToOrganNodeVo(organItem, organList)).collect(Collectors.toList());
        organNode.setChildren(children);
        return organNode;
    }

    @Override
    public OrganizationVo getOrganById(String organId) {
        return organizationDao.getOrganById(organId);
    }

    @Override
    public List<SimpleOrganVo> getOrgansByParentId(UUID parentId) {
        return organizationDao.getOrgansByParentId(parentId);
    }

    @Override
    public void deleteByIds(List<String> ids) {
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
