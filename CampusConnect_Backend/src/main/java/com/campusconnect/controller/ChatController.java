package com.campusconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusconnect.entity.ChatMessage;
import com.campusconnect.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    // Send Message
    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
        return chatService.sendMessage(chatMessage);
    }
    // Get Conversation
    @GetMapping("/conversation/{senderId}/{receiverId}")
    public List<ChatMessage> getConversation(
            @PathVariable Long senderId,
            @PathVariable Long receiverId) {

        return chatService.getConversation(senderId, receiverId);
    }

    // Get All Messages of a User
    @GetMapping("/user/{userId}")
    public List<ChatMessage> getMessagesByUser(
            @PathVariable Long userId) {

        return chatService.getMessagesByUser(userId);
    }
}