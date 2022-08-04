package com.horaoen.smart_safe_campus.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopOrganForCreateDto {

    @Schema(description = "组织名称")
    @NotEmpty(message = "组织名称不能为空")
    private String organName;

    @Schema(description = "排序值")
    private int orderField = 1;

}
