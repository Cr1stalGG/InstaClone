package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.Chat;
import com.instagram.InstaClone.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Chat> getAll(){
        return chatService.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Chat getChat(@PathVariable long id){
        return chatService.findById(id);
    }

    @RequestMapping(value = "/{chatId}/sendMessage", method = RequestMethod.POST)
    private void sendMessage(@PathVariable long chatId, @RequestBody long senderId, @RequestBody String messageText){
        chatService.sendMessage(chatId, senderId, messageText);
    }

    @RequestMapping(value = "/{chatId}/deleteMessage", method = RequestMethod.DELETE)
    public void deleteMessage(@PathVariable long chatId, @RequestBody long messageId){
        chatService.removeMessageById(chatId, messageId);
    }

    @RequestMapping(value = "/delete/{chatId}", method = RequestMethod.DELETE)
    public void deleteChat(@PathVariable long chatId){
        chatService.deleteChat(chatId);
    }
}
