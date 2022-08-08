package com.horaoen.smart_safe_campus.model.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForCreationDto {

    @Hidden
    private String id;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "姓名不能为空")
    private String realname;

    @NotEmpty(message = "手机号不能为空")
    private String phoneNumber;

    private int roleId;

    @NotEmpty(message = "组织Id不能为空")
    private String organId;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "确认密码不能为空")
    private String confirmedPassword;

    @Hidden
    private Date createTime;

}
