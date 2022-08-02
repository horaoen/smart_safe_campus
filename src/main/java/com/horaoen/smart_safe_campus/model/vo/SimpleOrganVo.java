package com.horaoen.smart_safe_campus.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleOrganVo {
    @Schema(description = "组织Id")
    private String organId;

    @Schema(description = "组织名称")
    private String organName;

    @Schema(description = "组织类型")
    private int organType;

    @Schema(description = "上级部门Id")
    private String parentId;

    @Schema(description = "排序值")
    private int orderField;
}
