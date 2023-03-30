package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.dto.UserUpdateRequestData;
import com.instagram.InstaClone.dto.conventor.UserConvertor;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements com.instagram.InstaClone.service.api.UserService {
    private final UserRepository userRepository;
    private final UserConvertor userConvertor;

    @Override
    public UserMainDataDTO findById(long id) {
        return userConvertor.convertMainDataToDTO(userRepository.findById(id));
    }

    @Override
    public void addUser(UserRegistrationRequest newUser) {
        User user = userConvertor.convertRegistrationRequestToEntity(newUser);

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
        List<UserMainDataDTO> users;

        users = userRepository.searchAllByUsername(username).stream().map(userConvertor::convertMainDataToDTO).toList();

        return users;
    }
}
