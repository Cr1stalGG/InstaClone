package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.entity.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserMainDataDTO {
    private final String username;
    private final String bio;
    private final List<Post> posts;
    private final long followsCounter;
    private final long followingCounter;

    public UserMainDataDTO(User user){
        this.username = user.getUsername();
        this.bio = user.getBio();
        this.posts = user.getPosts();
        this.followsCounter = user.getFollowers().size();
        this.followingCounter = user.getFollowing().size();
    }

}
