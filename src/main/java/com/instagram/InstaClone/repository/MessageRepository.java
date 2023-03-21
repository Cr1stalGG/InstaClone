package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findById(long id);
}
