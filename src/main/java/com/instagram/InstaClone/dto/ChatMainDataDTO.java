package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.entity.Message;
import lombok.Getter;

import java.util.List;

@Getter
public class ChatMainDataDTO {
    private final String firstUserUsername;
    private final String secondUserUsername;
    private final List<Message> messages;

    public ChatMainDataDTO(Chat chat) {
        this.firstUserUsername = chat.getFirstUser().getUsername();
        this.secondUserUsername = chat.getSecUser().getUsername();
        this.messages = chat.getMessages();
    }
}
