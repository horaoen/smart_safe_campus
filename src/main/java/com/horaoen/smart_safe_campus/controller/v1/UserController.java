package com.horaoen.smart_safe_campus.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "UserController", description = "用户管理")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    @Operation(description = "获得全部用户信息")
    public String getAllUsers() {
        ValueOperations<String, String> operations = this.stringRedisTemplate.opsForValue();
        return operations.get("a");
    }
}
