package com.instagram.InstaClone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRegistrationRequest {
    private String username;
    private String email;
    private String password;
}
