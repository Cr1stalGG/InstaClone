package com.instagram.InstaClone.service;

import com.instagram.InstaClone.entity.Role;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public void add(User user) {
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    public void update(long id, User newUser) {
        User user = userRepository.findById(id);

        if(newUser.getUsername() != null)
            user.setUsername(newUser.getUsername());

        if(newUser.getEmail() != null)
            user.setEmail(newUser.getEmail());

        if(newUser.getPassword() != null)
            user.setPassword(newUser.getPassword());

        if(newUser.getPosts() != null)
            user.setPosts(newUser.getPosts());

        userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }


    public void deleteAll() {
        userRepository.deleteAll();
    }

    public List<User> findAllByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }
}
