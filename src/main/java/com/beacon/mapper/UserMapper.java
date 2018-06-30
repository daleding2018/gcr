package com.beacon.mapper;

import com.beacon.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //根据用户名查询用户
    Account queryByName(String name);
}
