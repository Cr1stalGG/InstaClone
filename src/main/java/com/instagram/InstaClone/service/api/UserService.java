package com.instagram.InstaClone.service.api;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.dto.UserUpdateRequestData;
import com.instagram.InstaClone.security.AuthenticationRequest;
import com.instagram.InstaClone.security.AuthenticationResponse;

import java.util.List;

public interface UserService {
    UserMainDataDTO findById(long userId);

    List<UserMainDataDTO> findAllByUsername(String username);

    AuthenticationResponse addUser(UserRegistrationRequest newUser);

    void updateUser(long id, UserUpdateRequestData newUser);

    void deleteUserById(long userId);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
