package com.instagram.InstaClone.repository;

import com.instagram.InstaClone.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByName(String name);
}
