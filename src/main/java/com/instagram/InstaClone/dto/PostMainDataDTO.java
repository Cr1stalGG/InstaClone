package com.instagram.InstaClone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class PostMainDataDTO {
    private String topic;
    private String text;
    private long likes;
    private Date date;

}
