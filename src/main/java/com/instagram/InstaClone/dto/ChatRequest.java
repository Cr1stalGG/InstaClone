package com.instagram.InstaClone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChatRequest {
    private long firstUserID;
    private long secUserID;
}
