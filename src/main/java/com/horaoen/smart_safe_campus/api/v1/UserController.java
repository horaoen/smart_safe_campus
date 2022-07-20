package com.horaoen.smart_safe_campus.api.v1;

import com.horaoen.smart_safe_campus.model.User;
import com.horaoen.smart_safe_campus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author horaoen
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {

        List<User> all = userService.getAll();
        return all;
    }
}
