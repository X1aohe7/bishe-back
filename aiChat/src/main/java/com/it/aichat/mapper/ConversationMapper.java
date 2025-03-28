package com.it.aichat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.Conversation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConversationMapper extends BaseMapper<Conversation> {
}
