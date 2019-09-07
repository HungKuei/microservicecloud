package com.hungkuei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashBoardSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoardSpringApplication.class, args);
    }
}
