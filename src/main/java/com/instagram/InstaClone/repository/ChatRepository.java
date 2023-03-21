package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAll();
    Chat findById(long id);
}
