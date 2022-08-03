package com.horaoen.smart_safe_campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForCreationDto {
    private String username;
    private String realname;
    private String password;
    private String phoneNumber;
    private int roleId;

}
