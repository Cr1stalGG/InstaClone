package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/post")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable long id){
        return postRepository.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPost(@RequestParam Post post){
        postRepository.save(post);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestParam Post newPost){
        Post post = postRepository.findById(id);

        if(newPost.getTopic() != null)
            post.setTopic(newPost.getTopic());

        if(newPost.getText() != null)
            post.setText(newPost.getText());

        postRepository.save(post);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllPosts(){
        postRepository.deleteAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable long id){
        postRepository.deleteById(id);
    }
}
