package com.instagram.InstaClone.service.api;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.entity.Message;

import java.util.List;

public interface ChatService {
    List<ChatMainDataDTO> findAll();
    ChatMainDataDTO findById(long chatId);
    void addChat(ChatRequest newChat);
    void sendMessage(long chatId, Message message);
    void removeMessageById(long chatId, long messageId);
    void deleteChatById(long chatId);
}
