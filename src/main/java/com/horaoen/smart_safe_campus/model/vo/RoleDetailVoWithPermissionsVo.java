package com.horaoen.smart_safe_campus.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDetailVoWithPermissionsVo extends RoleDetailVo {
    @Schema(description = "菜单权限")
    private List<String> permissions;
}
