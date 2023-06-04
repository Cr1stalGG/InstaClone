package com.instagram.InstaClone.entity;

import com.instagram.InstaClone.entity.enumiration.Role;
import com.instagram.InstaClone.entity.enumiration.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class User implements UserDetails {
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
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> following;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> followers;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> posts;

    public void addPost(Post post){
        posts.add(post);
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
