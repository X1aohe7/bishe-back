package com.it.comment.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.UserNursingComment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<UserNursingComment> {
}
