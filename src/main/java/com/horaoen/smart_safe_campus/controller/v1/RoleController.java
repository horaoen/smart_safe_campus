package com.horaoen.smart_safe_campus.controller.v1;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import com.horaoen.smart_safe_campus.model.dto.RoleForCreateDto;
import com.horaoen.smart_safe_campus.service.PermissionService;
import com.horaoen.smart_safe_campus.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/role")
@Tag(name = "RoleController", description = "角色管理")
public class RoleController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    @Operation(description = "获取角色信息列表")
    public CommonResult getAllRole() {
        return CommonResult.success(roleService.getAll());
    }

    @GetMapping("/{roleId}")
    @Operation(description = "通过id获取角色详细信息")
    public CommonResult getRoleDetailWithPermissionByRoleId(@PathVariable long roleId) {
        RoleDetailVoWithPermissionsVo detail = roleService.getRoleDetailWithPermissionsByRoleId(roleId);
        return CommonResult.success(detail);
    }

    @DeleteMapping("/{roleId}")
    @Operation(description = "通过id删除角色详细信息")
    @Transactional
    public CommonResult deleteRoleDetailWithPermissionByRoleId(@PathVariable long roleId) {
        roleService.deleteRoleDetailWithPermissionByRoleId(roleId);
        return CommonResult.success(null);
    }

    @PostMapping
    @Operation(description = "添加角色信息")
    @Transactional
    public CommonResult addRoleDetailWithPermissions(
            @Valid @RequestBody RoleForCreateDto roleForCreateDto) {
        roleService.addRoleDetailWithPermissions(roleForCreateDto);
        return CommonResult.success(null);
    }

    @PutMapping("/{roleId}")
    @Operation(description = "修改角色信息")
    @Transactional
    public CommonResult updateRoleDetail(@Valid @RequestBody RoleForCreateDto roleForCreateDto, @PathVariable long roleId) {
        roleService.updateRoleDetail(roleId, roleForCreateDto);
        return CommonResult.success(null);
    }
}
