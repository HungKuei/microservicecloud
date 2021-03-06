package com.hungkuei.service;

import com.hungkuei.model.TUser;

import java.util.List;

public interface UserService {

    TUser findByUserId(Integer userId);

    List<TUser> findAll();
}
