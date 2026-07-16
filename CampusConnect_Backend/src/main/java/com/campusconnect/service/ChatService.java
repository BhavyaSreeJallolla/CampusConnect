package com.campusconnect.service;

import java.util.List;

import com.campusconnect.entity.ChatMessage;

public interface ChatService {

    // Send a new message
    ChatMessage sendMessage(ChatMessage chatMessage);

    // Get conversation between two users
    List<ChatMessage> getConversation(Long senderId, Long receiverId);

    // Get all messages of a user
    List<ChatMessage> getMessagesByUser(Long userId);

}