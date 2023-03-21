package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    void deleteById(long id);

    @Query("select  u from User u where u.username like %:#{#username}% order by u.username")
    List<User> searchAllByUsername(@Param("username") String username);
}
