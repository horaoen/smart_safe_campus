package com.horaoen.smart_safe_campus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author horaoen
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.horaoen.smart_safe_campus.dao"})
public class SmartSafeCampusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartSafeCampusApplication.class, args);
    }

}
