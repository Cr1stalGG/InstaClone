package com.instagram.InstaClone.dto.conventor;

import com.instagram.InstaClone.dto.CommentMainDataDTO;
import com.instagram.InstaClone.dto.CommentRequest;
import com.instagram.InstaClone.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentConvertor {
    public Comment convertCommentRequestToEntity(CommentRequest commentDTO){
        Comment comment = new Comment();

        if(commentDTO.getUserId() != 0) comment.setUserId(commentDTO.getUserId());
        comment.setComment(commentDTO.getComment());

        return comment;
    }

    public CommentMainDataDTO convertMainDataToDTO(Comment comment){
        CommentMainDataDTO commentDTO = new CommentMainDataDTO();

        commentDTO.setUserId(comment.getUserId());
        commentDTO.setComment(comment.getComment());

        return commentDTO;
    }
}
