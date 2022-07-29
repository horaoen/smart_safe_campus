package com.horaoen.smart_safe_campus.model.dto;

import com.horaoen.smart_safe_campus.model.OrganizationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationForCreateDto {
    @Schema(description = "组织Id", hidden = true)
    private UUID id;

    @Schema(description = "组织名称")
    private String organName;

    @Schema(description = "组织类型")
    private OrganizationType organType;

    @Schema(description = "排序值")
    private int orderField;

    @Schema(description = "上级部门Id", hidden = true)
    private UUID parentId;

}
