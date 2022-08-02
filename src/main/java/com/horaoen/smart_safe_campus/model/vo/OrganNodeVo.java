package com.horaoen.smart_safe_campus.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganNodeVo extends SimpleOrganVo{
    private List<OrganNodeVo> children;
}
