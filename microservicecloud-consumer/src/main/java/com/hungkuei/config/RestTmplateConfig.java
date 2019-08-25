package com.hungkuei.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTmplateConfig {

    @Bean
    @LoadBalanced  //SpringCloud Ribbon 是基于Netflix Ribbon 实现的一套客户端  负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
