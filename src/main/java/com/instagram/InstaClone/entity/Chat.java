package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CHATS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    private User firstUser;
    @OneToOne(fetch = FetchType.LAZY)
    private User secUser;
    @OneToMany(fetch = FetchType.LAZY)
    List<Message> messages;

    public void addMessage(Message message){
        messages.add(message);
    }

}
