package com.horaoen.smart_safe_campus.controller.v1;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.dto.OrganizationForCreateDto;
import com.horaoen.smart_safe_campus.model.vo.OrganizationVo;
import com.horaoen.smart_safe_campus.service.OrganizationService;
import com.horaoen.smart_safe_campus.util.StringUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Operation(description = "获取组织架构")
    public CommonResult getAllRegion() {
        return CommonResult.success(organizationService.getAllRegion());
    }

    @GetMapping("/{organId}")
    @Operation(description = "通过organId获取部门及子部门")
    public CommonResult getOrganById(@PathVariable String organId) {
        return CommonResult.success(organizationService.getOrganById(organId));
    }

    @PostMapping
    @Operation(description = "创建一级部门")
    public CommonResult addTopOrgan(@RequestBody OrganizationForCreateDto organization) {
        organization.setId(UUID.randomUUID().toString());
        organization.setOrganType(1);
        organizationService.addOrganization(organization);
        return CommonResult.success(organization);
    }

    @DeleteMapping()
    @Operation(description = "通过organId批量删除部门")
    public CommonResult deleteOrgans(@RequestParam String organIds) {
        List<String> uuids = StringUtil.StringToList(organIds);
        for (String id: uuids) {
            OrganizationVo organ = organizationService.getOrganById(id);
            if(organ == null) {
                return CommonResult.validateFailed("部门不存在, 请检查Id正确性");
            }
        }
        organizationService.deepDeleteOrgans(uuids);
        return CommonResult.success(null);
    }

    @PostMapping("/{parentId}")
    @Operation(description = "添加组织")
    public CommonResult addOrgan(@PathVariable String parentId, @RequestBody OrganizationForCreateDto organization) {
        organization.setId(UUID.randomUUID().toString());
        organization.setParentId(parentId);
        organizationService.addOrganization(organization);
        return CommonResult.success(null);
    }

    @PutMapping("/{organId}")
    @Operation(description = "更新组织信息")
    public CommonResult updateOrgan(@PathVariable String organId, @RequestBody OrganizationForCreateDto organization) {
        organization.setId(organId);
        organizationService.updateOrganization(organization);
        return CommonResult.success(null);
    }

}
