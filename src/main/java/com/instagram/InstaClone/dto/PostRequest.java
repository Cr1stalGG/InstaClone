package com.instagram.InstaClone.dto;

import com.instagram.InstaClone.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequest {
    private List<Image> images;
    private String topic;
    private String text;
}
