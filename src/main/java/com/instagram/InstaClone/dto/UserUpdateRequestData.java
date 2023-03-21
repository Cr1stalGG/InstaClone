package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.enumiration.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestData {
    private String email;
    private String username;
    private String password;
    private String bio;
    private Sex sex;
    private Date birthday;

}
