package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.dto.CommentMainDataDTO;
import com.instagram.InstaClone.dto.CommentRequest;
import com.instagram.InstaClone.service.api.PostService;
import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public List<PostMainDataDTO> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostMainDataDTO getPost(@PathVariable long id){
        return postService.findById(id);
    }

    @PostMapping()
    public void addPost(@PathVariable long userId, @RequestBody PostRequest postRequest, @ModelAttribute MultipartFile file){
        postService.addPost(userId, postRequest, file);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody PostRequest newPost){
        postService.update(id, newPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePostById(id);
    }

    @GetMapping("/comments/{id}")
    public List<CommentMainDataDTO> getComments(@PathVariable long id){
        return postService.getComments(id);
    }

    @PostMapping("/comments/{id}")
    public void addComment(@PathVariable long id, @RequestBody CommentRequest commentRequest){
        postService.addComment(id, commentRequest);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteCommentById(@PathVariable long id){
        postService.deleteCommentById(id);
    }

}
