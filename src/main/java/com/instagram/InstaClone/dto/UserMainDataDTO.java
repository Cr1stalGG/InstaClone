package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserMainDataDTO {
    private String username;
    private String bio;
    private List<Post> posts;
    private long followersCounter;
    private long followingCounter;

}
