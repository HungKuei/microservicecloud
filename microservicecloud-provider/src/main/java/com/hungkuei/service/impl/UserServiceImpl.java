package com.hungkuei.service.impl;

import com.hungkuei.mapper.UserMapper;
import com.hungkuei.model.TUser;
import com.hungkuei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public TUser findByUserId(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public List<TUser> findAll() {
        return userMapper.selectAll();
    }
}
