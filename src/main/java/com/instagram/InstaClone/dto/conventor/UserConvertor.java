package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.enumiration.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConvertor {

    public UserMainDataDTO convertMainDataToDTO(User user){
        UserMainDataDTO userDTO = new UserMainDataDTO();

        if (user.getUsername() != null) userDTO.setUsername(user.getUsername());
        if (user.getBio() != null) userDTO.setBio(user.getBio());
        if (user.getPosts() != null) userDTO.setPosts(user.getPosts());

        userDTO.setFollowersCounter(user.getFollowers().size());
        userDTO.setFollowingCounter(user.getFollowing().size());

        return userDTO;
    }

    public User convertRegistrationRequestToEntity(UserRegistrationRequest userDTO){
        User user = new User();

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());

        user.setRole(Role.USER);

        return user;
    }

}
