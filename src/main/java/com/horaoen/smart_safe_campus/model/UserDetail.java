package com.horaoen.smart_safe_campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    private String username;
    private String realname;
    private String phoneNumber;
    private String roleName;
    private String department;
    private String classDetail;
    private Date createTime;
}
