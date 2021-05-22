package com.example.websockets.websocketsexample.repository;

import com.example.websockets.websocketsexample.model.ChatMessage;
import com.example.websockets.websocketsexample.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
