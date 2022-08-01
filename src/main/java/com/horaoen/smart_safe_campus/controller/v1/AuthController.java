package com.horaoen.smart_safe_campus.controller.v1;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.dto.LoginDto;
import com.horaoen.smart_safe_campus.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@Tag(name = "Auth", description = "权限控制")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(description = "登录")
    public Object login(@RequestBody LoginDto loginUser) {
        return authService.login(loginUser);
    }

//    @GetMapping("/getAuthCode")
//    @Operation(description = "获取验证码")
//    public CommonResult getAuthCode(@RequestParam String telephone) {
//        return authService.generateAuthCode(telephone);
//    }

    @Operation(description = "判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return authService.verifyAuthCode(telephone,authCode);
    }

}
