package com.it.aichat.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.System;
import java.util.List;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.aichat.mapper.ConversationMapper;
import com.it.aichat.mapper.ConversationMessageMapper;
import com.it.aichat.service.AiChatService;
import com.it.common.entity.Conversation;
import com.it.common.entity.ConversationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AiChatServiceImpl implements AiChatService {

    @Autowired
    private ConversationMapper conversationMapper;

    @Autowired
    private ConversationMessageMapper messageMapper;

    // 创建新的对话记录
    public Conversation createConversation(Integer userId,String userInput) {
        Conversation conversation = new Conversation();
        conversation.setUserId(userId);
        conversation.setCreatedTime(LocalDateTime.now());
        conversation.setTitle(userInput);
        conversationMapper.insert(conversation);
        return conversation;
    }

    // 添加消息到某个对话中
    public void addMessage(Integer conversationId, String role, String content) {
        ConversationMessage message = new ConversationMessage();
        message.setConversationId(conversationId);
        message.setRole(role);
        message.setContent(content);
        message.setCreatedTime(LocalDateTime.now());
        messageMapper.insert(message);
    }

    // 获取某个对话的所有消息（按时间排序）
    public List<ConversationMessage> getMessages(Integer conversationId) {
        QueryWrapper<ConversationMessage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("conversation_id", conversationId)
                .orderByAsc("created_time");
        return messageMapper.selectList(queryWrapper);
    }

    public static GenerationParam createGenerationParam(List<Message> messages) {
        return GenerationParam.builder()
                // 若没有配置环境变量，请用百炼API Key将下行替换为：.apiKey("sk-xxx")
                .apiKey("sk-abbc077fbb5545929372165b639fdade")
                // 模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .model("qwen2.5-72b-instruct")
                .messages(messages)
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
    }
    public static GenerationResult callGenerationWithMessages(GenerationParam param) throws ApiException, NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        return gen.call(param);
    }

    private static Message createMessage(Role role, String content) {
        return Message.builder().role(role.getValue()).content(content).build();
    }



    @Override
    public ConversationMessage getAnswer(String userInput, Integer userId, Integer conversationId) {
        Conversation conversation;
        if (conversationId == null) {
            // 创建新的对话
            conversation = createConversation(userId,userInput);
        } else {
            // 获取现有对话
            conversation = conversationMapper.selectById(conversationId);

        }

        // 保存用户消息到数据库
        addMessage(conversation.getConversationId(), "user", userInput);

        // 获取对话历史消息
        List<ConversationMessage> historyMessages = getMessages(conversation.getConversationId());
        List<Message> messages = new ArrayList<>();
        for (ConversationMessage histMsg : historyMessages) {
            messages.add(Message.builder()
                    .role(histMsg.getRole())
                    .content(histMsg.getContent())
                    .build());
        }

        try {
            // 将用户输入添加到消息列表
            messages.add(Message.builder().role("user").content(userInput).build());

            GenerationParam param = createGenerationParam(messages);
            GenerationResult result = callGenerationWithMessages(param);
            Message aiMessage = result.getOutput().getChoices().get(0).getMessage();

            // 保存 AI 回复到数据库
            addMessage(conversation.getConversationId(), aiMessage.getRole(), aiMessage.getContent());

            // 构造并返回包含 AI 回复的 ConversationMessage 对象
            ConversationMessage responseMessage = new ConversationMessage();
            responseMessage.setConversationId(conversation.getConversationId());
            responseMessage.setRole(aiMessage.getRole());
            responseMessage.setContent(aiMessage.getContent());
            responseMessage.setCreatedTime(LocalDateTime.now());

            return responseMessage;
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Conversation> getChatHistory(Integer userId) {
        QueryWrapper<Conversation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return conversationMapper.selectList(queryWrapper);
    }

    @Override
    public List<ConversationMessage> getChatDetail(Integer ConversationId) {
        QueryWrapper<ConversationMessage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("conversation_id", ConversationId);
        return messageMapper.selectList(queryWrapper);
    }
}