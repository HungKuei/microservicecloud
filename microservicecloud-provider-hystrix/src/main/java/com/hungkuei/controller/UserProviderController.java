package com.hungkuei.controller;

import com.hungkuei.model.TUser;
import com.hungkuei.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider/user")
public class UserProviderController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{userId}")
    @HystrixCommand(fallbackMethod = "proccessHystrix_Get")
    public TUser getUser(@PathVariable("userId") Integer userId){
        TUser user = userService.findByUserId(userId);
        if (user == null){
            throw new RuntimeException("该ID:" + userId + "没有对应的信息");
        }
        return user;
    }

    @GetMapping("/get/list")
    public List<TUser> getAll(){
        return userService.findAll();
    }

    public TUser proccessHystrix_Get(@PathVariable("userId") Integer userId){
        return new TUser(userId, "该ID：" + userId + "没有对应信息，null--@HystrixCommand", 0);
    }
}
