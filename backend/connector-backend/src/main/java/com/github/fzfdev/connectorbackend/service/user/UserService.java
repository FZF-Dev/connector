package com.github.fzfdev.connectorbackend.service.user;

import com.github.fzfdev.connectorbackend.model.entity.User;

import java.util.Collection;
import java.util.UUID;

public interface UserService {
    boolean exists(UUID userUUID);

    void saveUser(User user);

    void addFollowerToUser(UUID userUUID, UUID followedUserUUID) throws Exception;

    void addBlockedUserToUser(UUID userUUID, UUID blockedUserUUID);

    Collection<User> getFollowersForUser(UUID userId);

    Collection<User> getFollowedForUser(UUID userId);

    UUID findUserIdByUsername(String username);

    Collection<User> findUsersByUsernameContainingIgnoreCase(String username);
}
