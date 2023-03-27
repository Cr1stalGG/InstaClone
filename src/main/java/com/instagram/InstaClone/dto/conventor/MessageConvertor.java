package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.MessageRequest;
import com.instagram.InstaClone.entity.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageConvertor {
    public Message convertMessageRequestToEntity(MessageRequest messageDTO){
        Message message = new Message();

        if(messageDTO.getSenderId() != 0) message.setSenderId(messageDTO.getSenderId());
        message.setMessage(messageDTO.getMessage());

        return message;
    }
}
