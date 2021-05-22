package com.example.websockets.websocketsexample.repository;

import com.example.websockets.websocketsexample.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    @Query("select chat from ChatRoom as chat " +
            "where chat.user1Id = :id1 and chat.user2Id = :id2 or " +
            "chat.user1Id = :id2 and chat.user2Id = :id1")
    ChatRoom findByUsers(String id1, String id2);
}
