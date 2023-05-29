package com.github.fzfdev.connectorbackend.service.user;

import com.github.fzfdev.connectorbackend.model.entity.User;
import com.github.fzfdev.connectorbackend.service.registry.RepositoryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {
    private RepositoryRegistry registry;

    @Autowired
    public UserServiceImplementation(RepositoryRegistry registry) {
        this.registry = registry;
    }

    @Override
    public boolean exists(UUID userUUID) {
        Optional<User> queriedUser = registry.getUserRepository().findUserByUserId(userUUID);
        return queriedUser.isPresent();
    }

    @Override
    public void saveUser(User user) {
        registry.getUserRepository().save(user);
    }

    @Override
    public void addFollowerToUser(UUID userUUID, UUID followedUserUUID) throws Exception {
    }

    @Override
    public void addBlockedUserToUser(UUID userUUID, UUID blockedUserUUID) {

    }

    @Override
    public Collection<User> getFollowersForUser(UUID userId) {
        return null;
    }

    @Override
    public Collection<User> getFollowedForUser(UUID userId) {
        return null;
    }

    @Override
    public UUID findUserIdByUsername(String username) {
        return null;
    }

    @Override
    public Collection<User> findUsersByUsernameContainingIgnoreCase(String username) {
        return null;
    }
}
