package com.it.comment.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.comment.client.UserClient;
import com.it.comment.mapper.CommentMapper;
import com.it.comment.service.CommentService;
import com.it.common.entity.User;
import com.it.common.entity.UserNursingComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/comment")
public class CommentController {

//    @Autowired
//    private CommentMapper commentMapper;
//
//    @Autowired
//    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody UserNursingComment userNursingComment){
//        commentMapper.insert(userNursingComment);
        commentService.save(userNursingComment);
        return ResponseEntity.ok("成功");
    }

    @GetMapping("/get")
    public ResponseEntity<List> get(@RequestParam Integer nid){
//        LambdaQueryWrapper<UserNursingComment> queryWrapper =
//                Wrappers.lambdaQuery(UserNursingComment.class);
//        queryWrapper.eq(UserNursingComment::getNursingId, nid);
//        List<UserNursingComment> userNursingComments = commentMapper.selectList(queryWrapper);
//        userNursingComments.forEach(userNursingComment -> {
//            User user = userMapper.selectById(userNursingComment.getUserId());
//            userNursingComment.setUserName(user.getName());
//            System.out.println(userNursingComment.getUserName());
//        });
//        return ResponseEntity.ok(userNursingComments);
        List<UserNursingComment> userNursingComments = commentService.getCommentByNursingId(nid);
        return ResponseEntity.ok(userNursingComments);
        
    }

    @GetMapping("/getProfile")
    public ResponseEntity<List<UserNursingComment>> getProfile(@RequestParam Integer nid) {
//        LambdaQueryWrapper<UserNursingComment> queryWrapper =
//                Wrappers.lambdaQuery(UserNursingComment.class);
//        queryWrapper.eq(UserNursingComment::getNursingId, nid).last("LIMIT 1"); // Adjust the limit as needed
//        List<UserNursingComment> userNursingComments = commentMapper.selectList(queryWrapper);
//
//        userNursingComments.forEach(userNursingComment -> {
//            User user = userMapper.selectById(userNursingComment.getUserId());
//            userNursingComment.setUserName(user.getName());
//            System.out.println(userNursingComment.getUserName());
//        });
        List<UserNursingComment> userNursingComments = commentService.getProfileByNursingId(nid);

        return ResponseEntity.ok(userNursingComments);
    }

}
