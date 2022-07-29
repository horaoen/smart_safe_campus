package com.horaoen.smart_safe_campus.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationVo extends SimpleOrganVo {
    @Schema(description = "排序值")
    private int orderField;
    @Schema(description = "子部门")
    private List<SimpleOrganVo> subOrgans;
}
