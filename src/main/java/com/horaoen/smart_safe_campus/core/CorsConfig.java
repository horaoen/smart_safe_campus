package com.horaoen.smart_safe_campus.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问
                .allowedOrigins("*") // 允许跨域访问的源
                .allowedMethods("POST","GET","PUT","DELETE","OPTIONS") //允许请求的方式
                .maxAge(168000) // 预检间隔时间
                .allowCredentials(true); // 是否发送Cookie
    }
}