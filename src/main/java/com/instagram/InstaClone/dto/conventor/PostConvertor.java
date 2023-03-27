package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import com.instagram.InstaClone.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostConvertor {
    public PostMainDataDTO convertMainDataToDTO(Post post){
        PostMainDataDTO postDTO = new PostMainDataDTO();

        if(post.getTopic() != null) postDTO.setTopic(post.getTopic());
        if(post.getText() != null) postDTO.setText(post.getText());
        postDTO.setComments(post.getComments());
        postDTO.setLikes(post.getLikes());
        postDTO.setDate(post.getDate());

        return postDTO;
    }

    public Post convertPostRequestDataToEntity(PostRequest postDTO){
        Post post = new Post();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        post.setTopic(postDTO.getTopic());
        post.setText(postDTO.getText());
        post.setLikes(0);
        post.setDate(sqlDate);

        return post;
    }
}
