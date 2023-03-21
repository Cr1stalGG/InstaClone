package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    void deleteById(long id);

    List<User> findAllByUsername(String username);
}
