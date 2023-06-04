package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserUpdateRequestData;
import com.instagram.InstaClone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserMainDataDTO getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody UserUpdateRequestData newUser){
        userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        userService.deleteUserById(id);
    }
}
