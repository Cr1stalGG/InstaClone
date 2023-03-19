package com.instagram.InstaClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "POST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TOPIC")
    private String topic;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "LIKES_COUNTER")
    private int likes;
    @Column(name = "DATE")
    private Date date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (likes != post.likes) return false;
        if (!Objects.equals(topic, post.topic)) return false;
        if (!Objects.equals(text, post.text)) return false;
        return Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + likes;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
