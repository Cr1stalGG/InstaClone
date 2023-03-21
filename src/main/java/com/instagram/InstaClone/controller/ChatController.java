package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.dto.ChatMainDataDTO;
import com.instagram.InstaClone.dto.ChatRequest;
import com.instagram.InstaClone.entity.Message;
import com.instagram.InstaClone.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@AllArgsConstructor
public class ChatController {
private final ChatService chatService;

    @GetMapping()
    public List<ChatMainDataDTO> getAll(){
        return chatService.findAll();
    }

    @GetMapping("/{id}")
    ChatMainDataDTO getChat(@PathVariable long id){
        return chatService.findById(id);
    }

    @PostMapping()
    public void addChat(@RequestBody ChatRequest chat){
        chatService.addChat(chat);
    }

    @PostMapping("/{chatId}")
    private void sendMessage(@PathVariable long chatId, @RequestBody Message message){
        chatService.sendMessage(chatId, message);
    }

    @DeleteMapping("/{chatId}/{messageId}")
    public void deleteMessage(@PathVariable long chatId, @PathVariable long messageId){
        chatService.removeMessageById(chatId, messageId);
    }

    @DeleteMapping("/{chatId}")
    public void deleteChat(@PathVariable long chatId){
        chatService.deleteChatById(chatId);
    }
}
