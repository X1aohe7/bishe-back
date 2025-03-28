package com.it.aichat.service;

import com.it.common.entity.Conversation;
import com.it.common.entity.ConversationMessage;

import java.util.List;

public interface AiChatService {
    ConversationMessage getAnswer(String userInput, Integer userId, Integer conversationId);
    List<Conversation> getChatHistory(Integer userId);
    List<ConversationMessage> getChatDetail(Integer ConversationId);
}
