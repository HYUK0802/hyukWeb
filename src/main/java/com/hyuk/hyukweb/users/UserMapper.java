package com.hyuk.hyukweb.users;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int insertUser(UserEntity userEntity);

    UserEntity selectUserById(@Param(value ="userid")String userid);
}
