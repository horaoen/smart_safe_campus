package com.horaoen.smart_safe_campus.controller.v1;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.SimpleOrganVo;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import com.horaoen.smart_safe_campus.util.StringUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/organ")
@Tag(name = "OrganizationController", description = "组织架构管理")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    @Operation(description = "获取组织架构地区")
    public CommonResult getAllRegion() {
        return CommonResult.success(organizationService.getAllRegion());
    }

    @GetMapping("/{organId}")
    @Operation(description = "通过organId获取部门及子部门")
    public OrganizationVo getOrganById(@PathVariable UUID organId) {
        return organizationService.getOrganById(organId);
    }

    @DeleteMapping("/{organIds}")
    @Operation(description = "通过organId删除部门")
    public void deleteOrgans(@PathVariable String organIds) {
        List<UUID> uuids = StringUtil.StringToUUIDs(organIds);
        organizationService.deepDeleteOrgans(uuids);
    }

    @PostMapping("/{parentId}")
    @Operation(description = "添加组织")
    public void addOrgan(@PathVariable String parentId, @RequestBody OrganizationForCreateDto organization) {
        organization.setId(UUID.randomUUID().toString());
        organization.setParentId(parentId);
        organizationService.addOrganization(organization);
    }

    @PutMapping("/{organId}")
    @Operation(description = "更新组织信息")
    public void updateOrgan(@PathVariable String organId, @RequestBody OrganizationForCreateDto organization) {
        organization.setId(organId);
        organizationService.updateOrganization(organization);
    }

}
