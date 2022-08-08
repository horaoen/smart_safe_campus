package com.horaoen.smart_safe_campus.model.vo;

import com.horaoen.smart_safe_campus.mbg.model.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends User {
    @Schema(description = "部门名称")
    private String organName;
    @Schema(description = "负责班级")
    private String className;
    private String createUser = "系统管理员";
}
