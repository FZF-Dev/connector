package com.github.fzfdev.connectorbackend.repository;

import com.github.fzfdev.connectorbackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsUserByUsernameAndPasswordAndUserEmail(String username, String password, String userEmail);

    Optional<User> findUserByUserId(UUID userId);

    Optional<User> findUserByUserName(String userName);

    Collection<User> findFollowersByUserId(@Param("userId") UUID userId);

    Collection<User> findFollowedByUserId(@Param("userId") UUID userId);

    Collection<User> findUsersByUsernameContainingIgnoreCase(@Param("username") String username);
}
