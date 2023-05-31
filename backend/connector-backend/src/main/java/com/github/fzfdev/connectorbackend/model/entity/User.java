package com.github.fzfdev.connectorbackend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(unique = true)
    private String handle;

    private String username;

    @Column
    private String password;

    @Column
    private String userBio;

    @Column
    private String userEmail;

    @Column
    private boolean isAdmin;

    @Column
    private boolean isBanned;

    @Column
    @CreationTimestamp
    private Timestamp dateOfRegistration;

    @Column
    @ManyToMany
    private Collection<User> followedUsers;

    @Column
    @ManyToMany
    private Collection<User> followers;

    @JoinColumn
    @ManyToMany
    private Collection<User> blockedUsers;

    public void addFollower(User follower) {
        if (followers == null) followers = new HashSet<>();

        followers.add(follower);
    }

    public void followUser(User user) {
        if (followedUsers == null) followedUsers = new HashSet<>();

        followedUsers.add(user);
    }

    public void blockUser(User user) {
        if (blockedUsers == null) {
            blockedUsers = new HashSet<>();
        }
        blockedUsers.add(user);
    }

    public boolean isFollowedBy(User follower) {
        UUID searchedUserId = follower.getUserId();
        return isFollowedBy(searchedUserId);
    }

    public boolean isFollowedBy(UUID followerId) {
        return followers.stream()
                .anyMatch(follower -> follower.getUserId().equals(followerId));
    }

    public boolean isFollowedBy(String username) {
        return followers
                .stream()
                .anyMatch(follower -> follower.getUsername().equals(username));
    }
}
