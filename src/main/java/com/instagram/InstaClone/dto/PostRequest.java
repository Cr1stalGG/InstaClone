package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequest {
    private Image image;
    private String topic;
    private String text;
}
