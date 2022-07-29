package com.horaoen.smart_safe_campus.model.vo;

import com.horaoen.smart_safe_campus.model.OrganizationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleOrganVo {
    @Schema(description = "组织Id")
    private UUID id;

    @Schema(description = "组织名称")
    private String organName;

    @Schema(description = "组织类型")
    private OrganizationType organType;
}
