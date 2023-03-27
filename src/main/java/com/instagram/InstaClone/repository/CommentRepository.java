package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
