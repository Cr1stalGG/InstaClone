package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.repository.ChatRepository;
import com.instagram.InstaClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChatConvertor {
    private final UserRepository userRepository;

    public ChatMainDataDTO convertMainDataToDTO(Chat chat){
        ChatMainDataDTO chatDTO = new ChatMainDataDTO();

        chatDTO.setFirstUserUsername(chat.getFirstUser().getUsername());
        chatDTO.setSecondUserUsername(chat.getSecUser().getUsername());
        chatDTO.setMessages(chat.getMessages());

        return chatDTO;
    }

    public Chat convertChatRequestToEntity(ChatRequest chatDTO){
        Chat chat = new Chat();

        chat.setFirstUser(userRepository.getReferenceById(chatDTO.getFirstUserID()));
        chat.setSecUser(userRepository.findById(chatDTO.getSecUserID()));

        return chat;
    }
}
