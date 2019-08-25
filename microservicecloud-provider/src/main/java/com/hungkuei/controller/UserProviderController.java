package com.hungkuei.controller;

import com.hungkuei.model.TUser;
import com.hungkuei.service.UserService;
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
    public TUser getUser(@PathVariable Integer userId){
        return userService.findByUserId(userId);
    }

    @GetMapping("/get/list")
    public List<TUser> getAll(){
        return userService.findAll();
    }
}
