package com.it.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.common.entity.UserNursingComment;

import java.util.List;

public interface CommentService extends IService<UserNursingComment> {
    List<UserNursingComment> getCommentByNursingId(Integer nursingId);

    List<UserNursingComment> getProfileByNursingId(Integer nursingId);
}
