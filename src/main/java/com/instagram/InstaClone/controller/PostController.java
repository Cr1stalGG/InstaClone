package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.service.api.PostService;
import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/posts")
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
    public void addPost(@RequestParam PostRequest post){
        postService.addPost(post);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestParam PostRequest newPost){
        postService.update(id, newPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePostById(id);
    }
}
