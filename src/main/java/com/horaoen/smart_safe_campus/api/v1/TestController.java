package com.horaoen.smart_safe_campus.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author horaoen
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String test() {
        return "hello";
    }
}
