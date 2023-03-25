package com.instagram.InstaClone.service.api;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.dto.UserUpdateRequestData;

import java.util.List;

public interface UserService {
    UserMainDataDTO findById(long userId);

    List<UserMainDataDTO> findAllByUsername(String username);

    void addUser(UserRegistrationRequest newUser);

    void updateUser(long id, UserUpdateRequestData newUser);

    void deleteUserById(long userId);
}
