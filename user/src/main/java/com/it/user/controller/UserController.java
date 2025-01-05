package com.it.user.controller;


import com.it.common.entity.User;
import com.it.common.entity.UserNursingComment;
import com.it.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> add(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("/getUserById")
    User getUserById(@RequestParam("id") Long id){
        return userService.getById(id);
    }

}
