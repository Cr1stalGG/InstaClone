package com.instagram.InstaClone.service.api;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.dto.MessageRequest;

import java.util.List;

public interface ChatService {
    List<ChatMainDataDTO> findAll();
    ChatMainDataDTO findById(long chatId);
    void addChat(ChatRequest newChat);
    void sendMessage(long chatId, MessageRequest messageDTO);
    void removeMessageById(long chatId, long messageId);
    void deleteChatById(long chatId);
}
