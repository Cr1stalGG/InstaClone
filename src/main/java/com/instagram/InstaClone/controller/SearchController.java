package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {
    private final UserService userService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<User> findAllByUsername(@PathVariable String username){
        return userService.findAllByUsername(username);
    }
}
