package com.hungkuei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //EurekaServer 服务器端启动类，接受其他微服务注册进来
public class EurekaServerSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSpringApplication.class, args);
    }
}
