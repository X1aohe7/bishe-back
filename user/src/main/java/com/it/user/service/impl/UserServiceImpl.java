package com.it.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.common.entity.User;
import com.it.common.entity.UserNursingComment;
import com.it.user.mapper.UserMapper;
import com.it.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<Object> login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);
        queryWrapper.eq(User::getUsername, username).eq(User::getPassword, password);
        User user1 = userMapper.selectOne(queryWrapper);
        if(user1 == null) {
            return new ResponseEntity<>("用户名密码不匹配或密码不正确", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(user1);

    }


}
