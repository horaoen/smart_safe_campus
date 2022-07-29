package com.horaoen.smart_safe_campus.service;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.LoginDto;

public interface AuthService {
    User getUserByUsername(String username);

    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);
    CommonResult login(LoginDto loginUser);
}
