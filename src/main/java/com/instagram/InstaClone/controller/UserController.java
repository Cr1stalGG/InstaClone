package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable long id, @RequestBody User newUser){
        User user = userRepository.findById(id);

        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setPosts(newUser.getPosts());

        userRepository.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll(){
        userRepository.deleteAll();
    }
}
