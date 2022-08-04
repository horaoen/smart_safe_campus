package com.horaoen.smart_safe_campus.model.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleForCreateDto {
    @Hidden
    private int id;

    @Schema(description = "角色名称")
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "菜单权限")
    @NotEmpty(message = "菜单权限不能为空")
    private List<String> permissions;
}
