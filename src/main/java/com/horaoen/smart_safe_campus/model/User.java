package com.horaoen.smart_safe_campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author horaoen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String realname;
    private String phoneNumber;
    private Long roleId;
    private Long organId;
    private Long createUserId;
    private Date createTime;
}
