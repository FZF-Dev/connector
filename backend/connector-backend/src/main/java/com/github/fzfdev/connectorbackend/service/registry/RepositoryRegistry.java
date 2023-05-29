package com.github.fzfdev.connectorbackend.service.registry;

import com.github.fzfdev.connectorbackend.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter @Service
public class RepositoryRegistry {
    private final UserRepository userRepository;

    @Autowired
    public RepositoryRegistry(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
