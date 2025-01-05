package com.it.collect.controller;

import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingCollect;
import com.it.collect.service.UserNursingCollectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/collect")
public class UserNursingCollectController {

    @Autowired
    private UserNursingCollectService userNursingCollectService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody UserNursingCollect userNursingCollect){
        LambdaQueryWrapper<UserNursingCollect> queryWrapper =
                Wrappers.lambdaQuery(UserNursingCollect.class);
        queryWrapper.eq(UserNursingCollect::getNursingId, userNursingCollect.getNursingId()).eq(UserNursingCollect::getUserId, userNursingCollect.getUserId());
        List<UserNursingCollect> list = userNursingCollectService.list(queryWrapper);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>("已经收藏，请勿重复收藏", HttpStatus.BAD_REQUEST);
        }

        userNursingCollectService.save(userNursingCollect);
        return ResponseEntity.ok("成功");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> remove(@RequestBody UserNursingCollect userNursingCollect){
        userNursingCollectService.remove(userNursingCollect.getUserId(), userNursingCollect.getNursingId());
        return ResponseEntity.ok("成功");
    }

    @GetMapping("/get")
    public ResponseEntity<List> get(@RequestParam Integer uid){
        List<Nursing> byUid = userNursingCollectService.findByUid(uid);
        return ResponseEntity.ok(byUid);
    }
}
