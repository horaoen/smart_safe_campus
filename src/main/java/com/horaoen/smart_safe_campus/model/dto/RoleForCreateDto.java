package com.horaoen.smart_safe_campus.model.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleForCreateDto {
    @Hidden
    private int id;
    @Schema(description = "角色名称")
    private String roleName;
    @Schema(description = "备注")
    private String description;
    @Schema(description = "菜单权限")
    private List<String> permissions;
}
