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
//    public LoginResult login(UserEntity user) {
//        UserEntity existingUser = this.userMapper.selectUserById(user.getUserid());
//        if(existingUser == null) {
//            return LoginResult.FAILURE_id;
//        }
//        user.setPassword(CryptoUtil.hashSha512(user.getPassword()));
//        if(!user.getPassword().equals(existingUser.getPassword())) {
//            return LoginResult.FAILURE_pw;
//        }
//        user.setUserid(existingUser.getUserid());
//        user.setName(existingUser.getName());
//        user.setAge(existingUser.getAge());
//        return LoginResult.SUCCESS;
//    }
public LoginResult login(UserEntity user) {
    UserEntity existingUser = this.userMapper.selectUserById(user.getUserid());
    if (existingUser == null) {
        System.out.println("User not found: " + user.getUserid());
        return LoginResult.FAILURE_id;
    }
    System.out.println("Existing user found: " + existingUser.getUserid());

    user.setPassword(CryptoUtil.hashSha512(user.getPassword()));
    if (!user.getPassword().equals(existingUser.getPassword())) {
        return LoginResult.FAILURE_pw;
    }
    user.setUserid(existingUser.getUserid());
    user.setName(existingUser.getName());
    user.setAge(existingUser.getAge());
    return LoginResult.SUCCESS;
}


}
