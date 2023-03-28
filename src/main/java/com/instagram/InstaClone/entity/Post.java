package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "POSTS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TOPIC")
    private String topic;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "LIKES_COUNTER")
    private long likes;
    @Column(name = "DATE")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    private Image image;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public void addComment(Comment comment){
        comments.add(comment);
    }
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", likes=" + likes +
                ", date=" + date +
                '}';
    }

}
