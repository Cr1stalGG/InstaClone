package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.PostMainDataDTO;
import com.instagram.InstaClone.dto.PostRequest;
import com.instagram.InstaClone.entity.Image;
import com.instagram.InstaClone.entity.Post;
import com.instagram.InstaClone.util.ImageUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@AllArgsConstructor
public class PostConvertor {
    public PostMainDataDTO convertMainDataToDTO(Post post){
        PostMainDataDTO postDTO = new PostMainDataDTO();

        if(post.getTopic() != null) postDTO.setTopic(post.getTopic());
        if(post.getText() != null) postDTO.setText(post.getText());
        postDTO.setImage(post.getImage());
        postDTO.setComments(post.getComments());
        postDTO.setLikes(post.getLikes());
        postDTO.setDate(post.getDate());

        return postDTO;
    }

    public Post convertPostRequestDataToEntity(PostRequest postDTO, MultipartFile file) throws IOException {
        Post post = new Post();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        if(file != null) post.setImage(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        post.setTopic(postDTO.getTopic());
        post.setText(postDTO.getText());
        post.setLikes(0);
        post.setDate(sqlDate);

        return post;
    }
}
