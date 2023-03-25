package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMainDataDTO {
    private String firstUserUsername;
    private String secondUserUsername;
    private List<Message> messages;
}
