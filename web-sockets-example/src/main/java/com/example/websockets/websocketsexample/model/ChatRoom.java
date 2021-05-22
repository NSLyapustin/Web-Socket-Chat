package com.example.websockets.websocketsexample.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "itis_room")
public class ChatRoom {
    @Id
    @GeneratedValue
    private long id;

    private String user2Id;

    private String user1Id;

}
