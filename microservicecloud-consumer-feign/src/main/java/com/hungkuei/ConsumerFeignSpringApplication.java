package com.hungkuei;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hungkuei"})
@ComponentScan("com.hungkuei")
public class ConsumerFeignSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignSpringApplication.class, args);
    }
}
