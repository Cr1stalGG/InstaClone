package com.instagram.InstaClone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentMainDataDTO {
    private long userId;
    private String comment;
}
