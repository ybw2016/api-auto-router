package com.demo.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.demo")
public class ApiAutoRouterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiAutoRouterApplication.class, args);
    }
}
