package com.it.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.comment.client.UserClient;
import com.it.comment.mapper.CommentMapper;
import com.it.comment.service.CommentService;
import com.it.common.entity.User;
import com.it.common.entity.UserNursingComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, UserNursingComment>
        implements CommentService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<UserNursingComment> getCommentByNursingId(Integer nursingId) {
        LambdaQueryWrapper<UserNursingComment> queryWrapper =
        Wrappers.lambdaQuery(UserNursingComment.class);
        queryWrapper.eq(UserNursingComment::getNursingId, nursingId);
        List<UserNursingComment> userNursingComments = commentMapper.selectList(queryWrapper);
        userNursingComments.forEach(userNursingComment -> {
            User user = userClient.getUserById(Long.valueOf(userNursingComment.getUserId()));
            userNursingComment.setUserName(user.getName());
            System.out.println(userNursingComment.getUserName());
        });
        return userNursingComments;
    }

    @Override
    public List<UserNursingComment> getProfileByNursingId(Integer nursingId) {
        LambdaQueryWrapper<UserNursingComment> queryWrapper =
                Wrappers.lambdaQuery(UserNursingComment.class);
        queryWrapper.eq(UserNursingComment::getNursingId, nursingId).last("LIMIT 1"); // Adjust the limit as needed
        List<UserNursingComment> userNursingComments = commentMapper.selectList(queryWrapper);

        userNursingComments.forEach(userNursingComment -> {
            User user = userClient.getUserById(Long.valueOf(userNursingComment.getUserId()));
            userNursingComment.setUserName(user.getName());
            System.out.println(userNursingComment.getUserName());
        });
        return userNursingComments;
    }
}
