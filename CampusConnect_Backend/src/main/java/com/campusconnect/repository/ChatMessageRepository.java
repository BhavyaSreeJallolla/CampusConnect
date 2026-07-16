package com.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusconnect.entity.ChatMessage;
import com.campusconnect.entity.User;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findBySender(User sender);

    List<ChatMessage> findByReceiver(User receiver);

    List<ChatMessage> findBySenderAndReceiver(User sender, User receiver);

}