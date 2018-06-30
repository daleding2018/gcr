package com.beacon.service;

import com.beacon.entity.Account;
import com.beacon.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class  UserService {

    @Resource
    private UserMapper userMapper;

    //根据用户名查询用户
    public Account queryByName(String name){
        return userMapper.queryByName(name);
    }
}
