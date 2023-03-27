package com.instagram.InstaClone.entity;

import com.instagram.InstaClone.entity.enumiration.Role;
import com.instagram.InstaClone.entity.enumiration.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "BIO")
    private String bio;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "SEX")
    private Sex sex;
    @Column(name = "ROLE")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> following;
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> followers;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }
}
