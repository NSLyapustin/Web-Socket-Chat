package com.example.websockets.websocketsexample.service;

import com.example.websockets.websocketsexample.model.ChatMessage;
import com.example.websockets.websocketsexample.repository.ChatMessageRepository;
import com.example.websockets.websocketsexample.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage save(ChatMessage message) {
        return chatMessageRepository.save(message);
    }
}
