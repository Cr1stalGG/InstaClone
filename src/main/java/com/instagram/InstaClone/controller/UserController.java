package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable long id, @RequestBody User newUser){
        userService.update(id, newUser);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        userService.deleteById(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll(){
        userService.deleteAll();
    }
}
