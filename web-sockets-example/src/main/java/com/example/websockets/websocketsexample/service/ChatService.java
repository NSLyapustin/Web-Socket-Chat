package com.example.websockets.websocketsexample.service;

import com.example.websockets.websocketsexample.model.ChatRoom;
import com.example.websockets.websocketsexample.repository.ChatMessageRepository;
import com.example.websockets.websocketsexample.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatRoom getOrCreate(String sender, String recipient) {
        ChatRoom chatRoom = chatRoomRepository.findByUsers(sender, recipient);
        if (chatRoom == null) {
            ChatRoom newChatRoom = new ChatRoom();
            newChatRoom.setUser1Id(sender);
            newChatRoom.setUser2Id(recipient);
            return chatRoomRepository.save(newChatRoom);
        }
        return chatRoom;
    }
}
