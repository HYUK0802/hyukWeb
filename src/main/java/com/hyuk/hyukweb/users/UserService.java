package com.hyuk.hyukweb.users;

import com.hyuk.hyukweb.utils.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public RegisterResult register(UserEntity user) {
        if (this.userMapper.selectUserById(user.getUserid()) != null) {
            return RegisterResult.FAILURE_DUPLICATE_ID;
        }
        user.setPassword(CryptoUtil.hashSha512(user.getPassword()));
        return this.userMapper.insertUser(user) > 0 ?
                RegisterResult.SUCCESS : RegisterResult.FAILURE;
    }

}
