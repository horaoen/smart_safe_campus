package com.horaoen.smart_safe_campus.controller.v1;

import com.github.pagehelper.PageHelper;
import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.model.dto.UserForCreationDto;
import com.horaoen.smart_safe_campus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "UserController", description = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    @Operation(description = "获得全部用户信息")
    public CommonResult getAllUsers(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return CommonResult.success(userService.getAllUsers());
    }

    @DeleteMapping("/{userId}")
    @Operation(description = "删除用户信息")
    public CommonResult deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return CommonResult.success(null);
    }

    @PostMapping()
    @Operation(description = "新增用户")
    public CommonResult createUser(@RequestBody UserForCreationDto user) {
        userService.createUser(user);
        return CommonResult.success(null);
    }
}
