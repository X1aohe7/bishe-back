package com.it.aichat.controller;

import com.it.aichat.service.AiChatService;
import com.it.common.entity.Conversation;
import com.it.common.entity.ConversationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AiChatController {

    @Autowired
    private AiChatService aiChatService;

    @GetMapping("/getChatDetail")
    public ResponseEntity<List<ConversationMessage>> getChatDetail(@RequestParam("conversationId") int conversationId) {
        return ResponseEntity.ok(aiChatService.getChatDetail(conversationId));
    }

    @GetMapping("/getChatHistory")
    public ResponseEntity<List<Conversation>> getChatHistory(@RequestParam("userId") Integer userId) {
        return ResponseEntity.ok(aiChatService.getChatHistory(userId));

    }

    @PostMapping("/getAnswer")
    public ResponseEntity<ConversationMessage> getAnswer(@RequestParam("userInput") String userInput,
                                                         @RequestParam("userId") Integer userId,
                                                         @RequestParam(value = "conversationId", required = false) Integer conversationId) {

        ConversationMessage answer = aiChatService.getAnswer(userInput, userId,conversationId);
        if (answer == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } else {
            return ResponseEntity.ok(answer);
        }
    }
}
