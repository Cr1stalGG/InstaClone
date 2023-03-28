package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.CommentMainDataDTO;
import com.instagram.InstaClone.dto.CommentRequest;
import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import com.instagram.InstaClone.dto.conventor.CommentConvertor;
import com.instagram.InstaClone.dto.conventor.PostConvertor;
import com.instagram.InstaClone.entity.Comment;
import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.repository.CommentRepository;
import com.instagram.InstaClone.repository.PostRepository;
import com.instagram.InstaClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService implements com.instagram.InstaClone.service.api.PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final CommentConvertor commentConvertor;
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

    @SneakyThrows
    @Override
    public void addPost(long userId, PostRequest newPost, MultipartFile file) {
        User user = userRepository.findById(userId);

        user.addPost(postConvertor.convertPostRequestDataToEntity(newPost, file));

        userRepository.save(user);
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

    @Override
    public List<CommentMainDataDTO> getComments(long postId) {
        List<CommentMainDataDTO> commentDTOList = new ArrayList<>();

        for(Comment comment : postRepository.findById(postId).getComments())
            commentDTOList.add(commentConvertor.convertMainDataToDTO(comment));

        return commentDTOList;
    }

    @Override
    public void addComment(long postId, CommentRequest commentDTO) {
        Post post = postRepository.findById(postId);
        Comment comment = commentConvertor.convertCommentRequestToEntity(commentDTO);

        post.addComment(comment);

        postRepository.save(post);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

}
