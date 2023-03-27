package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.dto.MessageRequest;
import com.instagram.InstaClone.dto.conventor.ChatConvertor;
import com.instagram.InstaClone.dto.conventor.MessageConvertor;
import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.entity.Message;
import com.instagram.InstaClone.repository.ChatRepository;
import com.instagram.InstaClone.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService implements com.instagram.InstaClone.service.api.ChatService {
    private final ChatConvertor chatConvertor;
    private final MessageRepository messageRepository;
    private final MessageConvertor messageConvertor;
    private final ChatRepository chatRepository;

    @Override
    public List<ChatMainDataDTO> findAll() {
        List<ChatMainDataDTO> chatList = new ArrayList<>();

        for(Chat chat : chatRepository.findAll())
            chatList.add(chatConvertor.convertMainDataToDTO(chat));

        return chatList;
    }

    @Override
    public ChatMainDataDTO findById(long id){
        return chatConvertor.convertMainDataToDTO(chatRepository.findById(id));
    }

    @Override
    public void removeMessageById(long chatId, long messageId){
        Chat chat = chatRepository.findById(chatId);
        Message message = messageRepository.findById(messageId);

        chat.getMessages().remove(message);

        chatRepository.save(chat);
    }

    @Override
    public void sendMessage(long chatId, MessageRequest messageDTO){
        Chat chat = chatRepository.findById(chatId);
        Message message = messageConvertor.convertMessageRequestToEntity(messageDTO);

        messageRepository.save(message);

        chat.addMessage(message);

        chatRepository.save(chat);
    }

    @Override
    public void deleteChatById(long chatId){
        Chat chat = chatRepository.findById(chatId);

        chatRepository.delete(chat);
    }

    @Override
    public void addChat(ChatRequest newChat) {
        chatRepository.save(chatConvertor.convertChatRequestToEntity(newChat));
    }
}
