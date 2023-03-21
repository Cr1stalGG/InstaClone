package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.entity.Message;
import com.instagram.InstaClone.repository.ChatRepository;
import com.instagram.InstaClone.repository.MessageRepository;
import com.instagram.InstaClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService implements com.instagram.InstaClone.api.ChatService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    @Override
    public List<ChatMainDataDTO> findAll() {
        List<ChatMainDataDTO> chatList = new ArrayList<>();

        for(Chat chat : chatRepository.findAll())
            chatList.add(new ChatMainDataDTO(chat));

        return chatList;
    }

    @Override
    public ChatMainDataDTO findById(long id){
        return new ChatMainDataDTO(chatRepository.findById(id));
    }

    @Override
    public void removeMessageById(long chatId, long messageId){
        Chat chat = chatRepository.findById(chatId);
        Message message = messageRepository.findById(messageId);

        chat.getMessages().remove(message);

        chatRepository.save(chat);
    }

    @Override
    public void sendMessage(long chatId,  Message message){
        Chat chat = chatRepository.findById(chatId);

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
        Chat chat = new Chat();

        chat.setFirstUser(userRepository.findById(newChat.getFirstUserID()));
        chat.setSecUser(userRepository.findById(newChat.getSecUserID()));

        chatRepository.save(chat);
    }
}
