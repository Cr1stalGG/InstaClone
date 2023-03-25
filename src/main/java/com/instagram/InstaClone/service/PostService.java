package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import com.instagram.InstaClone.dto.conventor.PostConvertor;
import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService implements com.instagram.InstaClone.service.api.PostService {
    private final PostRepository postRepository;
    private final PostConvertor postConvertor;
    @Override
    public List<PostMainDataDTO> findAll() {
        List<PostMainDataDTO> posts = new ArrayList<>();

        for(Post post : postRepository.findAll())
            posts.add(postConvertor.convertMainDataToDTO(post));

        return posts;
    }

    @Override
    public PostMainDataDTO findById(long postId) {
        return postConvertor.convertMainDataToDTO(postRepository.findById(postId));
    }

    @Override
    public void addPost(PostRequest newPost) {
        postRepository.save(postConvertor.convertPostRequestDataToEntity(newPost));
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
