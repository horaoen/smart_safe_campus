package com.horaoen.smart_safe_campus.model.dto;

import com.horaoen.smart_safe_campus.model.OrganizationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationForCreateDto {
    @Schema(description = "组织Id", hidden = true)
    private String id;

    @Schema(description = "组织名称")
    @NotEmpty(message = "组织名称不能为空")
    private String organName;

    @Schema(description = "组织类型")
    @Range(min = 1, max = 4, message = "组织类型号必须在1-4之间")
    private int organType;

    @Schema(description = "排序值")
    private int orderField = 1;

    @Schema(description = "上级部门Id", hidden = true)
    private String parentId;

}
