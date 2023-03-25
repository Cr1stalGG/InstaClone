package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "MESSAGES")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "SENDER_ID")
    private  long senderId;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", senderId=" + senderId +
                '}';
    }
}
