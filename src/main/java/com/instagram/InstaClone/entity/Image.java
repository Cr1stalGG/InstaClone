package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IMAGES")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Lob
    @Column(name = "IMAGE_DATA", length = 1000)
    private byte[] imageData;
}
