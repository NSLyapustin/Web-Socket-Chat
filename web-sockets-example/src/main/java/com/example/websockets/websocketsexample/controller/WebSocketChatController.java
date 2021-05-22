package com.example.websockets.websocketsexample.controller;

import com.example.websockets.websocketsexample.model.ChatMessage;
import com.example.websockets.websocketsexample.model.ChatRoom;
import com.example.websockets.websocketsexample.service.ChatMessageService;
import com.example.websockets.websocketsexample.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void chat(@Payload ChatMessage message){
        ChatRoom chat = chatService.getOrCreate(message.getSenderId(), message.getRecipientId());
        message.setChatRoom(chat);
        chatMessageService.save(message);
        message = chatMessageService.save(message);

        messagingTemplate.convertAndSendToUser(message.getRecipientId(), "/queue/messages", message);
    }
}
