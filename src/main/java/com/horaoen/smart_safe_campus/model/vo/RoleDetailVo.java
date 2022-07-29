package com.horaoen.smart_safe_campus.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDetailVo {
    private long id;
    @Schema(description = "备注")
    private String description;
    @Schema(description = "角色名称")
    private String roleName;
}
