package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService implements com.instagram.InstaClone.api.PostService {
    private final PostRepository postRepository;
    @Override
    public List<PostMainDataDTO> findAll() {
        List<PostMainDataDTO> posts = new ArrayList<>();

        for(Post post : postRepository.findAll())
            posts.add(new PostMainDataDTO(post));

        return posts;
    }

    @Override
    public PostMainDataDTO findById(long postId) {
        return new PostMainDataDTO(postRepository.findById(postId));
    }

    @Override
    public void addPost(PostRequest newPost) {
        Post post = new Post();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        post.setTopic(newPost.getTopic());
        post.setText(newPost.getText());
        post.setLikes(0);
        post.setDate(sqlDate);

        postRepository.save(post);
    }

    @Override
    public void update(long id, PostRequest newPost) {
        Post post = postRepository.findById(id);

        if(newPost.getTopic() != null)
            post.setTopic(newPost.getTopic());

        if(newPost.getText() != null)
            post.setText(newPost.getText());

        postRepository.save(post);
    }

    @Override
    public void deletePostById(long postId) {
        postRepository.deleteById(postId);
    }
}
