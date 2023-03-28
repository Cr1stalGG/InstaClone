package com.instagram.InstaClone.service.api;

import com.instagram.InstaClone.dto.CommentMainDataDTO;
import com.instagram.InstaClone.dto.CommentRequest;
import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    List<PostMainDataDTO> findAll();
    PostMainDataDTO findById(long postId);
    void addPost(long userId, PostRequest newPost, MultipartFile file);
    void update(long id, PostRequest newPost);
    void deletePostById(long postId);

    List<CommentMainDataDTO> getComments(long postId);
    void addComment(long postId, CommentRequest commentDTO);
    void deleteCommentById(long id);

}
