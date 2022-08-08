package com.horaoen.smart_safe_campus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author horaoen
 */
@SpringBootApplication
public class SmartSafeCampusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartSafeCampusApplication.class, args);
    }

}
