package com.instagram.InstaClone.service;

import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.entity.Message;
import com.instagram.InstaClone.repository.ChatRepository;
import com.instagram.InstaClone.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(MessageRepository messageRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
    }

    public List<Chat> findAll(){
        return chatRepository.findAll();
    }

    public Chat findById(long id){
        return chatRepository.findById(id);
    }

    public void removeMessageById(long chatId, long messageId){
        Chat chat = chatRepository.findById(chatId);
        Message message = messageRepository.findById(messageId);

        chat.getMessages().remove(message);

        chatRepository.save(chat);
    }

    public void sendMessage(long chatId,  Message message){
        Chat chat = chatRepository.findById(chatId);

        messageRepository.save(message);

        chat.addMessage(message);

        chatRepository.save(chat);
    }

    public void deleteChat(long chatId) {
        Chat chat = chatRepository.findById(chatId);

        chatRepository.delete(chat);
    }

    public void save(Chat chat) {
        chatRepository.save(chat);
    }
}
