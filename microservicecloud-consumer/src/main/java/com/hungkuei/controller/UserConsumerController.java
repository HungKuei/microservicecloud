package com.hungkuei.controller;

import com.hungkuei.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserConsumerController {

    private static final String REST_URL_PREIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/user/get/{userId}")
    public TUser getUser(@PathVariable Long userId){
        return restTemplate.getForObject(REST_URL_PREIX + "/provider/user/get/" + userId, TUser.class);
    }

    @RequestMapping("/consumer/user/get/list")
    public List<TUser> getAll(){
        return restTemplate.getForObject(REST_URL_PREIX + "/provider/user/get/list", List.class);
    }
}
