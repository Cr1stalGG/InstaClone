package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.dto.UserUpdateRequestData;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.enumiration.Role;
import com.instagram.InstaClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements com.instagram.InstaClone.api.UserService {
    private final UserRepository userRepository;

    @Override
    public UserMainDataDTO findById(long id) {
        return new UserMainDataDTO(userRepository.findById(id));
    }

    @Override
    public void addUser(UserRegistrationRequest newUser) {
        User user = new User();

        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, UserUpdateRequestData newUser) {
        User user = userRepository.findById(id);

        if(newUser.getUsername() != null)
            user.setUsername(newUser.getUsername());

        if(newUser.getBio() != null)
            user.setBio(newUser.getBio());

        if(newUser.getEmail() != null)
            user.setEmail(newUser.getEmail());

        if(newUser.getPassword() != null)
            user.setPassword(newUser.getPassword());

        if(newUser.getBirthday() !=  null)
            user.setBirthday(newUser.getBirthday());

        if(newUser.getSex() != null)
            user.setSex(newUser.getSex());

        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserMainDataDTO> findAllByUsername(String username) {
        List<UserMainDataDTO> users = new ArrayList<>();

        for(User user : userRepository.searchAllByUsername(username))
            users.add(new UserMainDataDTO(user));

        return users;
    }
}
