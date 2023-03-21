package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final UserService userService;

    @Autowired
    public SearchController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<User> findAllByUsername(@PathVariable String username){
        return userService.findAllByUsername(username);
    }
}
