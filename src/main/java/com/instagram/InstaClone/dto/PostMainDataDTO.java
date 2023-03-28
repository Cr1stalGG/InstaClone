package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Comment;
import com.instagram.InstaClone.entity.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PostMainDataDTO {
    private String topic;
    private String text;
    private long likes;
    private Date date;
    private Image image;
    private List<Comment> comments;

}
