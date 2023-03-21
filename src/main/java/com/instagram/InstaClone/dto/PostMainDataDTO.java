package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Post;
import lombok.Getter;

import java.sql.Date;

@Getter
public class PostMainDataDTO {
    private final String topic;
    private final String text;
    private final long likes;
    private final Date date;

    public PostMainDataDTO(Post post) {
        this.topic = post.getTopic();
        this.text = post.getText();
        this.likes = post.getLikes();
        this.date = post.getDate();
    }
}
