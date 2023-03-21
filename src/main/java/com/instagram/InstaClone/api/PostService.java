package com.instagram.InstaClone.api;

import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;

import java.util.List;

public interface PostService {
    List<PostMainDataDTO> findAll();
    PostMainDataDTO findById(long postId);
    void addPost(PostRequest newPost);
    void update(long id, PostRequest newPost);
    void deletePostById(long postId);

}
