package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
    void deleteById(long id);
}
