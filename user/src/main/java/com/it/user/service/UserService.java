package com.it.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.common.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService extends IService<User> {
     ResponseEntity<Object> login(User user);
}
