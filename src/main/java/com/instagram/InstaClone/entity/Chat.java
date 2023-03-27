package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CHATS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    private User firstUser;
    @OneToOne(fetch = FetchType.EAGER)
    private User secUser;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messages;

    public void addMessage(Message message){
        messages.add(message);
    }

}
