package com.hungkuei.controller;

import com.hungkuei.model.TUser;
import com.hungkuei.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConsumerFeignController {

    @Autowired
    private UserClientService userClientService;

    @RequestMapping("/consumer/user/get/{userId}")
    public TUser getUser(@PathVariable Integer userId){
        return userClientService.getByUserId(userId);
    }

    @RequestMapping("/consumer/user/get/list")
    public List<TUser> getAll(){
        return userClientService.getAll();
    }

}
